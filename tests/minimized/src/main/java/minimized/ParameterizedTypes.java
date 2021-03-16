package minimized;

import java.util.List;

public class ParameterizedTypes<A, B> {
  //Class<?> clazz;

  public String app(A a, B b) {
    return a.toString() + b;
  }

  public List<?> doStuff() { return null; }
}
