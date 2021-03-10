package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^^ reference android/os/Handler#

import static com.airbnb.epoxy.EpoxyAsyncUtil.MAIN_THREAD_HANDLER;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAsyncUtil#
import static com.airbnb.epoxy.EpoxyAsyncUtil.getAsyncBackgroundHandler;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAsyncUtil#

/**
 * A subclass of {@link EpoxyController} that makes it easy to do model building and diffing in
 * the background.
 * <p>
 * See https://github.com/airbnb/epoxy/wiki/Epoxy-Controller#asynchronous-support
 */
public abstract class AsyncEpoxyController extends EpoxyController {
//                    ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyController#
//                                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#

  /**
   * A new instance that does model building and diffing asynchronously.
   */
  public AsyncEpoxyController() {
//       ^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyController#`<init>`().
    this(true);
//  ^^^^ reference com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+1).
  }

  /**
   * @param enableAsync True to do model building and diffing asynchronously, false to do them
   *                    both on the main thread.
   */
  public AsyncEpoxyController(boolean enableAsync) {
//       ^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+1).
//                                    ^^^^^^^^^^^ definition local0
    this(enableAsync, enableAsync);
//  ^^^^ reference com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+2).
//       ^^^^^^^^^^^ reference local0
//                    ^^^^^^^^^^^ reference local0
  }

  /**
   * Individually control whether model building and diffing are done async or on the main thread.
   */
  public AsyncEpoxyController(boolean enableAsyncModelBuilding, boolean enableAsyncDiffing) {
//       ^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+2).
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition local1
//                                                                      ^^^^^^^^^^^^^^^^^^ definition local2
    super(getHandler(enableAsyncModelBuilding), getHandler(enableAsyncDiffing));
//  ^^^^^ reference com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//        ^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference local1
//                                              ^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                                                         ^^^^^^^^^^^^^^^^^^ reference local2
  }

  private static Handler getHandler(boolean enableAsync) {
//               ^^^^^^^ reference _root_/
//                       ^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                                          ^^^^^^^^^^^ definition local3
    return enableAsync ? getAsyncBackgroundHandler() : MAIN_THREAD_HANDLER;
//         ^^^^^^^^^^^ reference local3
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAsyncUtil#getAsyncBackgroundHandler().
//                                                     ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAsyncUtil#MAIN_THREAD_HANDLER.
  }
}
