package com.airbnb.epoxy;

/** Interface applied to generated models to allow the base adapter to interact with them. */
public interface GeneratedModel<T> {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/GeneratedModel#
//                              ^ definition com/airbnb/epoxy/GeneratedModel#[T]
  /**
   * Called on the generated model immediately before the main model onBind method has been called.
   * This let's the generated model handle binding setup of its own
   * <p>
   * The ViewHolder is needed to get the model's adapter position when clicked.
   */
  void handlePreBind(EpoxyViewHolder holder, T objectToBind, int position);
//     ^^^^^^^^^^^^^ definition com/airbnb/epoxy/GeneratedModel#handlePreBind().
//                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                   ^^^^^^ definition local0
//                                           ^ reference com/airbnb/epoxy/GeneratedModel#[T]
//                                             ^^^^^^^^^^^^ definition local1
//                                                               ^^^^^^^^ definition local2
  /**
   * Called on the generated model immediately after the main model onBind method has been called.
   * This let's the generated model handle binding of its own and dispatch calls to its onBind
   * listener.
   * <p>
   * We don't want to rely on the main onBind method to dispatch the onBind listener call because
   * there are two onBind methods (one for payloads and one for no payloads), and one can call into
   * the other. We don't want to dispatch two onBind listener calls in that case.
   */
  void handlePostBind(T objectToBind, int position);
//     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/GeneratedModel#handlePostBind().
//                    ^ reference com/airbnb/epoxy/GeneratedModel#[T]
//                      ^^^^^^^^^^^^ definition local3
//                                        ^^^^^^^^ definition local4
}
