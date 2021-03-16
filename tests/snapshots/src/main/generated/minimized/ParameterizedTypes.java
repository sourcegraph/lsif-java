package minimized;

import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

public class ParameterizedTypes<A, B> {
//           ^^^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes#
//           ^^^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes#`<init>`().
//                              ^ definition minimized/ParameterizedTypes#[A]
//                                 ^ definition minimized/ParameterizedTypes#[B]
  //Class<?> clazz;

  public String app(A a, B b) {
//       ^^^^^^ reference java/lang/String#
//              ^^^ definition minimized/ParameterizedTypes#app().
//                  ^ reference minimized/ParameterizedTypes#[A]
//                    ^ definition local0
//                       ^ reference minimized/ParameterizedTypes#[B]
//                         ^ definition local1
    return a.toString() + b;
//         ^ reference local0
//           ^^^^^^^^ reference java/lang/Object#toString().
//                        ^ reference local1
  }

  public List<?> doStuff() { return null; }
//       ^^^^ reference java/util/List#
//               ^^^^^^^ definition minimized/ParameterizedTypes#doStuff().
}
