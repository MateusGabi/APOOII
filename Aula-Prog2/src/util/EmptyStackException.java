package util;

public class EmptyStackException
  extends RuntimeException
{
  EmptyStackException()
  {
    super("Empty stack exception");
  }

  EmptyStackException(String message)
  {
    super(message);
  }

} // RuntimeException
