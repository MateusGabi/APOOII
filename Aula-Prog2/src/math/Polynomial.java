package math;

import util.*;

class PolynomialIterator
  implements Iterator<Polynomial.Term>
{
  @Override
  public boolean hasNext()
  {
    return current != terms;
  }

  @Override
  public Polynomial.Term next()
  {
    Polynomial.Term t = new Polynomial.Term(current);

    current = current.next;
    return t;
  }

  PolynomialIterator(Polynomial.Term terms)
  {
    this.terms = terms;
    current = terms.next;
  }

  private final Polynomial.Term terms;
  private Polynomial.Term current;
    
} // PolynomialIterator
  
public class Polynomial
{
  public static class Term
  {
    public Term(float coefficient, int expoent)
    {
      // if (expoent < 0)
      //   TODO
      this.coefficient = coefficient;
      this.expoent = expoent;
    }

    public Term(float coefficient)
    {
      this.coefficient = coefficient;
      expoent = 0;
    }

    public Term(Term other)
    {
      coefficient = other.coefficient;
      expoent = other.expoent;
    }

    public float getCoefficient()
    {
      return coefficient;
    }

    public int getExpoent()
    {
      return expoent;
    }

    @Override
    public String toString()
    {
      String format;

      if (expoent == 0)
        format = "%+.2f";
      else if (expoent == 1)
        format = "%+.2fx";
      else
        format = "%+.2fx^%d";
      return String.format(format, coefficient, expoent);
    }

    float coefficient;
    int expoent;
    Term next;
    Term previous;

  } // Term

  public static Polynomial add(Polynomial a, Polynomial b)
  {
    return (new Polynomial(a)).add(b);
  }

  public static Polynomial mul(Polynomial a, Polynomial b)
  {
    return (new Polynomial(a)).mul(b);
  }

  public static Polynomial mul(Polynomial p, float s)
  {
    return (new Polynomial(p)).mul(s);
  }

  public static Polynomial mul(float s, Polynomial p)
  {
    return (new Polynomial(p)).mul(s);
  }

  public Polynomial()
  {
    terms = new Term(0);
    terms.next = terms.previous = terms;
  }

  public Polynomial(float coefficient)
  {
    this();
    if (coefficient != 0)
      addLast(new Term(coefficient));
  }

  public Polynomial(Term term)
  {
    this();
    if (term.coefficient != 0)
      addLast(new Term(term));
  }

  public Polynomial(Polynomial p)
  {
    this();
    for (Term t = p.terms.next; t != p.terms; t = t.next)
      addLast(new Term(t));
  }

  public Polynomial add(float coefficient)
  {
    if (coefficient != 0)
      addTerm(new Term(coefficient));
    return this;
  }

  public Polynomial add(Term term)
  {
    if (term.coefficient != 0)
      addTerm(new Term(term));
    return this;
  }

  public Polynomial add(Polynomial p)
  {
    for (Term t = p.terms.next; t != p.terms; t = t.next)
      addTerm(new Term(t));
    return this;
  }

  public Polynomial mul(float coefficient)
  {
    if (coefficient == 0)
    {
      terms.next = terms.previous = terms;
      count = 0;
    }
    else if (coefficient != 1)
      for (Term t = terms.next; t != terms; t = t.next)
        t.coefficient *= coefficient;
    return this;
  }

  public Polynomial mul(Term term)
  {
    // TODO
    return this;
  }

  public Polynomial mul(Polynomial p)
  {
    // TODO
    return this;
  }

  public final int size()
  {
    return count;
  }

  public boolean isZero()
  {
    return terms.next == terms;
  }

  public Iterator iterator()
  {
    return new PolynomialIterator(terms);
  }

  private final Term terms;
  private int count;

  private void addBefore(Term next, Term term)
  {
    next.previous.next = term;
    term.previous = next.previous;
    next.previous = term;
    term.next = next;
    ++count;    
  }

  private void addLast(Term term)
  {
    addBefore(terms, term);
  }

  private void addTerm(Term term)
  {
    Term next = terms.next;

    while (next != terms)
    {
      int cmp = term.expoent - next.expoent;

      if (cmp > 0)
        break;
      else if (cmp == 0)
      {
        if ((next.coefficient += term.coefficient) == 0)
        {
          next.previous.next = next.next;
          next.next.previous = next.previous;
          --count;
        }
        return;
      }
      next = next.next;        
    }
    addBefore(next, term);
  }

} // Polynomial
