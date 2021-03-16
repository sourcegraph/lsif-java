package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference android/
//             ^^^^^^^^ reference android/graphics/
//                      ^^^^^^ reference android/graphics/Canvas#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
import java.util.Arrays;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^ reference java/util/Arrays#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.recyclerview.widget.ItemTouchHelper;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/ItemTouchHelper#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#

import static androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags;
//            ^^^^^^^^ reference androidx/
//                     ^^^^^^^^^^^^ reference androidx/recyclerview/
//                                  ^^^^^^ reference androidx/recyclerview/widget/
//                                         ^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/ItemTouchHelper/
//                                                         ^^^^^^^^ reference androidx/recyclerview/widget/ItemTouchHelper/Callback#

/**
 * A simple way to set up drag or swipe interactions with Epoxy.
 * <p>
 * Drag events work with the EpoxyController and automatically update the controller and
 * RecyclerView when an item is moved. You just need to implement a callback to update your data to
 * reflect the change.
 * <p>
 * Both swipe and drag events implement a small lifecycle to help you style the views as they are
 * moved. You can register callbacks for the lifecycle events you care about.
 * <p>
 * If you want to set up multiple drag and swipe rules for the same RecyclerView, you can use this
 * class multiple times to specify different targets or swipe and drag directions and callbacks.
 * <p>
 * If you want more control over configuration and handling, you can opt to not use this class and
 * instead you can implement {@link EpoxyModelTouchCallback} directly with your own {@link
 * ItemTouchHelper}. That class provides an interface that makes it easier to work with Epoxy models
 * and simplifies touch callbacks.
 * <p>
 * If you want even more control you can implement {@link EpoxyTouchHelperCallback}. This is just a
 * light layer over the normal RecyclerView touch callbacks, but it converts all view holders to
 * Epoxy view holders to remove some boilerplate for you.
 */
public abstract class EpoxyTouchHelper {
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#`<init>`().

  /**
   * The entry point for setting up drag support.
   *
   * @param controller The EpoxyController with the models that will be dragged. The controller will
   *                   be updated for you when a model is dragged and moved by a user's touch
   *                   interaction.
   */
  public static DragBuilder initDragging(EpoxyController controller) {
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#
//                          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#initDragging().
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                                       ^^^^^^^^^^ definition local0
    return new DragBuilder(controller);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#`<init>`().
//             ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#
//                         ^^^^^^^^^^ reference local0
  }

  public static class DragBuilder {
//                    ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.

    private DragBuilder(EpoxyController controller) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#`<init>`().
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                      ^^^^^^^^^^ definition local1
      this.controller = controller;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#this.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.
//                      ^^^^^^^^^^ reference local1
    }

    /**
     * The recyclerview that the EpoxyController has its adapter added to. An {@link
     * androidx.recyclerview.widget.ItemTouchHelper} will be created and configured for you, and
     * attached to this RecyclerView.
     */
    public DragBuilder2 withRecyclerView(RecyclerView recyclerView) {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#
//                      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#withRecyclerView().
//                                       ^^^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^^^^^^^ definition local2
      return new DragBuilder2(controller, recyclerView);
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#`<init>`().
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.
//                                        ^^^^^^^^^^^^ reference local2
    }
  }

  public static class DragBuilder2 {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.

    private DragBuilder2(EpoxyController controller, RecyclerView recyclerView) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#`<init>`().
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local3
//                                                   ^^^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^^^ definition local4
      this.controller = controller;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#this.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                      ^^^^^^^^^^ reference local3
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                        ^^^^^^^^^^^^ reference local4
    }

    /** Enable dragging vertically, up and down. */
    public DragBuilder3 forVerticalList() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forVerticalList().
      return withDirections(ItemTouchHelper.UP | ItemTouchHelper.DOWN);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^ reference UP#
//                                               ^^^^^^^^^^^^^^^ reference _root_/
//                                                               ^^^^ reference DOWN#
    }

    /** Enable dragging horizontally, left and right. */
    public DragBuilder3 forHorizontalList() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forHorizontalList().
      return withDirections(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^ reference LEFT#
//                                                 ^^^^^^^^^^^^^^^ reference _root_/
//                                                                 ^^^^^ reference RIGHT#
    }

    /** Enable dragging in all directions. */
    public DragBuilder3 forGrid() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forGrid().
      return withDirections(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^ reference UP#
//                                               ^^^^^^^^^^^^^^^ reference _root_/
//                                                               ^^^^ reference DOWN#
//                                                                      ^^^^^^^^^^^^^^^ reference _root_/
//                                                                                      ^^^^ reference LEFT#
          | ItemTouchHelper.RIGHT);
//          ^^^^^^^^^^^^^^^ reference _root_/
//                          ^^^^^ reference RIGHT#
    }

    /**
     * Set custom movement flags to dictate which drag directions should be allowed.
     * <p>
     * Can be any of {@link ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link
     * ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN}, {@link ItemTouchHelper#START}, {@link
     * ItemTouchHelper#END}
     * <p>
     * Flags can be OR'd together to allow multiple directions.
     */
    public DragBuilder3 withDirections(int directionFlags) {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                                         ^^^^^^^^^^^^^^ definition local5
      return new DragBuilder3(controller, recyclerView, makeMovementFlags(directionFlags, 0));
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#`<init>`().
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                                                      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#makeMovementFlags#
//                                                                        ^^^^^^^^^^^^^^ reference local5
    }
  }

  public static class DragBuilder3 {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.

    private DragBuilder3(EpoxyController controller, RecyclerView recyclerView, int movementFlags) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#`<init>`().
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local6
//                                                   ^^^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^^^ definition local7
//                                                                                  ^^^^^^^^^^^^^ definition local8
      this.controller = controller;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#this.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                      ^^^^^^^^^^ reference local6
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                        ^^^^^^^^^^^^ reference local7
      this.movementFlags = movementFlags;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#this.
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                         ^^^^^^^^^^^^^ reference local8
    }

    /**
     * Set the type of Epoxy model that is draggable. This approach works well if you only have one
     * draggable type.
     */
    public <U extends EpoxyModel> DragBuilder4<U> withTarget(Class<U> targetModelClass) {
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//                                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().
//                                                           ^^^^^ reference java/lang/Class#
//                                                                 ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//                                                                    ^^^^^^^^^^^^^^^^ definition local9
      List<Class<? extends EpoxyModel>> targetClasses = new ArrayList<>(1);
//    ^^^^ reference java/util/List#
//         ^^^^^ reference java/lang/Class#
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^^^^ definition local10
//                                                      ^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                                                          ^^^^^^^^^ reference java/util/ArrayList#
      targetClasses.add(targetModelClass);
//    ^^^^^^^^^^^^^ reference local10
//                  ^^^ reference java/util/List#add().
//                      ^^^^^^^^^^^^^^^^ reference local9

      return new DragBuilder4<>(controller, recyclerView, movementFlags, targetModelClass,
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`(). 1:24
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                                                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                                                                       ^^^^^^^^^^^^^^^^ reference local9
          targetClasses);
//        ^^^^^^^^^^^^^ reference local10
    }

    /**
     * Specify which Epoxy model types are draggable. Use this if you have more than one type that
     * is draggable.
     * <p>
     * If you only have one draggable type you should use {@link #withTarget(Class)}
     */
    public DragBuilder4<EpoxyModel> withTargets(Class<? extends EpoxyModel>... targetModelClasses) {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTargets().
//                                              ^^^^^ reference java/lang/Class#
//                                                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                             ^^^^^^^^^^^^^^^^^^ definition local11
      return new DragBuilder4<>(controller, recyclerView, movementFlags, EpoxyModel.class,
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`(). 1:44
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                                                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                                                                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                  ^^^^^ reference com/airbnb/epoxy/EpoxyModel#class.
          Arrays.asList(targetModelClasses));
//        ^^^^^^ reference java/util/Arrays#
//               ^^^^^^ reference java/util/Arrays#asList().
//                      ^^^^^^^^^^^^^^^^^^ reference local11
    }

    /**
     * Use this if all models in the controller should be draggable, and if there are multiple types
     * of models in the controller.
     * <p>
     * If you only have one model type you should use {@link #withTarget(Class)}
     */
    public DragBuilder4<EpoxyModel> forAllModels() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#forAllModels().
      return withTarget(EpoxyModel.class);
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^ reference com/airbnb/epoxy/EpoxyModel#class.
    }
  }

  public static class DragBuilder4<U extends EpoxyModel> {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                                 ^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
    private final Class<U> targetModelClass;
//                ^^^^^ reference java/lang/Class#
//                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.
    private final List<Class<? extends EpoxyModel>> targetModelClasses;
//                ^^^^ reference java/util/List#
//                     ^^^^^ reference java/lang/Class#
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.

    private DragBuilder4(EpoxyController controller,
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`().
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local12
        RecyclerView recyclerView, int movementFlags,
//      ^^^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^^ definition local13
//                                     ^^^^^^^^^^^^^ definition local14
        Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//               ^^^^^^^^^^^^^^^^ definition local15
//                                 ^^^^ reference java/util/List#
//                                      ^^^^^ reference java/lang/Class#
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                   ^^^^^^^^^^^^^^^^^^ definition local16

      this.controller = controller;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                      ^^^^^^^^^^ reference local12
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.
//                        ^^^^^^^^^^^^ reference local13
      this.movementFlags = movementFlags;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
//                         ^^^^^^^^^^^^^ reference local14
      this.targetModelClass = targetModelClass;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.
//                            ^^^^^^^^^^^^^^^^ reference local15
      this.targetModelClasses = targetModelClasses;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                              ^^^^^^^^^^^^^^^^^^ reference local16
    }

    /**
     * Set callbacks to handle drag actions and lifecycle events.
     * <p>
     * You MUST implement {@link DragCallbacks#onModelMoved(int, int, EpoxyModel,
     * View)} to update your data to reflect an item move.
     * <p>
     * You can optionally implement the other callbacks to modify the view being dragged. This is
     * useful if you want to change things like the view background, size, color, etc
     *
     * @return An {@link ItemTouchHelper} instance that has been initialized and attached to a
     * recyclerview. The touch helper has already been fully set up and can be ignored, but you may
     * want to hold a reference to it if you need to later detach the recyclerview to disable touch
     * events via setting null on {@link ItemTouchHelper#attachToRecyclerView(RecyclerView)}
     */
    public ItemTouchHelper andCallbacks(final DragCallbacks<U> callbacks) {
//         ^^^^^^^^^^^^^^^ reference _root_/
//                         ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#andCallbacks().
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#
//                                                          ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                             ^^^^^^^^^ definition local17
      ItemTouchHelper itemTouchHelper =
//    ^^^^^^^^^^^^^^^ reference _root_/
//                    ^^^^^^^^^^^^^^^ definition local18
          new ItemTouchHelper(new EpoxyModelTouchCallback<U>(controller, targetModelClass) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference `<init>`# 37:12
//            ^^^^^^^^^^^^^^^ reference _root_/
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local20 37:11
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                                                                       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.
//                                                                                         ^ definition local21 2:7
//                                                                                         ^ definition local22 2:13
//                                                                                           reference java/lang/ 2:2
//                                                                                           reference com/airbnb/epoxy/ 2:3
//                                                                                           reference java/lang/Class# 2:3
//                                                                                           reference com/airbnb/ 2:4
//                                                                                           reference com/airbnb/epoxy/EpoxyController# 2:13

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public int getMovementFlagsForModel(U model, int adapterPosition) {
//                     ^^^^^^^^^^^^^^^^^^^^^^^^ definition local23
//                                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                ^^^^^ definition local24
//                                                           ^^^^^^^^^^^^^^^ definition local25
              return movementFlags;
//                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            protected boolean isTouchableModel(EpoxyModel<?> model) {
//                            ^^^^^^^^^^^^^^^^ definition local26
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local27
              boolean isTargetType = targetModelClasses.size() == 1
//                    ^^^^^^^^^^^^ definition local28
//                                   ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                                                      ^^^^ reference java/util/List#size().
                  ? super.isTouchableModel(model)
//                  ^^^^^ reference local29
//                        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                         ^^^^^ reference local27
                  : targetModelClasses.contains(model.getClass());
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                                     ^^^^^^^^ reference java/util/List#contains().
//                                              ^^^^^ reference local27
//                                                    ^^^^^^^^ reference java/lang/Object#getClass().

              //noinspection unchecked
              return isTargetType && callbacks.isDragEnabledForModel((U) model);
//                   ^^^^^^^^^^^^ reference local28
//                                   ^^^^^^^^^ reference local17
//                                             ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#isDragEnabledForModel().
//                                                                    ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                                       ^^^^^ reference local27
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onDragStarted(U model, View itemView, int adapterPosition) {
//                      ^^^^^^^^^^^^^ definition local30
//                                    ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                      ^^^^^ definition local31
//                                             ^^^^ reference _root_/
//                                                  ^^^^^^^^ definition local32
//                                                                ^^^^^^^^^^^^^^^ definition local33
              callbacks.onDragStarted(model, itemView, adapterPosition);
//            ^^^^^^^^^ reference local17
//                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragStarted().
//                                    ^^^^^ reference local31
//                                           ^^^^^^^^ reference local32
//                                                     ^^^^^^^^^^^^^^^ reference local33
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onDragReleased(U model, View itemView) {
//                      ^^^^^^^^^^^^^^ definition local34
//                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                       ^^^^^ definition local35
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^ definition local36
              callbacks.onDragReleased(model, itemView);
//            ^^^^^^^^^ reference local17
//                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragReleased().
//                                     ^^^^^ reference local35
//                                            ^^^^^^^^ reference local36
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onModelMoved(int fromPosition, int toPosition, U modelBeingMoved,
//                      ^^^^^^^^^^^^ definition local37
//                                       ^^^^^^^^^^^^ definition local38
//                                                         ^^^^^^^^^^ definition local39
//                                                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                                       ^^^^^^^^^^^^^^^ definition local40
                View itemView) {
//              ^^^^ reference _root_/
//                   ^^^^^^^^ definition local41
              callbacks.onModelMoved(fromPosition, toPosition, modelBeingMoved, itemView);
//            ^^^^^^^^^ reference local17
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onModelMoved().
//                                   ^^^^^^^^^^^^ reference local38
//                                                 ^^^^^^^^^^ reference local39
//                                                             ^^^^^^^^^^^^^^^ reference local40
//                                                                              ^^^^^^^^ reference local41
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void clearView(U model, View itemView) {
//                      ^^^^^^^^^ definition local42
//                                ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                  ^^^^^ definition local43
//                                         ^^^^ reference _root_/
//                                              ^^^^^^^^ definition local44
              callbacks.clearView(model, itemView);
//            ^^^^^^^^^ reference local17
//                      ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#clearView().
//                                ^^^^^ reference local43
//                                       ^^^^^^^^ reference local44
            }
          });

      itemTouchHelper.attachToRecyclerView(recyclerView);
//    ^^^^^^^^^^^^^^^ reference local18
//                    ^^^^^^^^^^^^^^^^^^^^ reference attachToRecyclerView#
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.

      return itemTouchHelper;
//           ^^^^^^^^^^^^^^^ reference local18
    }
  }

  public abstract static class DragCallbacks<T extends EpoxyModel>
//                             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#
//                             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#`<init>`().
//                                           ^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
      implements EpoxyDragCallback<T> {
//               ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyDragCallback#
//                                 ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onDragStarted(T model, View itemView, int adapterPosition) {
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragStarted().
//                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                              ^^^^^ definition local45
//                                     ^^^^ reference _root_/
//                                          ^^^^^^^^ definition local46
//                                                        ^^^^^^^^^^^^^^^ definition local47

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onDragReleased(T model, View itemView) {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragReleased().
//                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                               ^^^^^ definition local48
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^^ definition local49

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public abstract void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved,
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onModelMoved().
//                                        ^^^^^^^^^^^^ definition local50
//                                                          ^^^^^^^^^^ definition local51
//                                                                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                                                        ^^^^^^^^^^^^^^^ definition local52
        View itemView);
//      ^^^^ reference _root_/
//           ^^^^^^^^ definition local53

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void clearView(T model, View itemView) {
//              ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#clearView().
//                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                          ^^^^^ definition local54
//                                 ^^^^ reference _root_/
//                                      ^^^^^^^^ definition local55

    }

    /**
     * Whether the given model should be draggable.
     * <p>
     * True by default. You may override this to toggle draggability for a model.
     */
    public boolean isDragEnabledForModel(T model) {
//                 ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#isDragEnabledForModel().
//                                       ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                         ^^^^^ definition local56
      return true;
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public final int getMovementFlagsForModel(T model, int adapterPosition) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#getMovementFlagsForModel().
//                                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                              ^^^^^ definition local57
//                                                         ^^^^^^^^^^^^^^^ definition local58
      // No-Op this is not used
      return 0;
    }
  }

  /**
   * The entry point for setting up swipe support for a RecyclerView. The RecyclerView must be set
   * with an Epoxy adapter or controller.
   */
  public static SwipeBuilder initSwiping(RecyclerView recyclerView) {
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#
//                           ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#initSwiping().
//                                       ^^^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^^^^^^^ definition local59
    return new SwipeBuilder(recyclerView);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#`<init>`().
//             ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#
//                          ^^^^^^^^^^^^ reference local59
  }

  public static class SwipeBuilder {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.

    private SwipeBuilder(RecyclerView recyclerView) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#`<init>`().
//                       ^^^^^^^^^^^^ reference _root_/
//                                    ^^^^^^^^^^^^ definition local60
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                        ^^^^^^^^^^^^ reference local60
    }

    /** Enable swiping right. */
    public SwipeBuilder2 right() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#right().
      return withDirections(ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^^ reference RIGHT#
    }

    /** Enable swiping left. */
    public SwipeBuilder2 left() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#left().
      return withDirections(ItemTouchHelper.LEFT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^ reference LEFT#
    }

    /** Enable swiping horizontally, left and right. */
    public SwipeBuilder2 leftAndRight() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#leftAndRight().
      return withDirections(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^ reference LEFT#
//                                                 ^^^^^^^^^^^^^^^ reference _root_/
//                                                                 ^^^^^ reference RIGHT#
    }

    /**
     * Set custom movement flags to dictate which swipe directions should be allowed.
     * <p>
     * Can be any of {@link ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link
     * ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN}, {@link ItemTouchHelper#START}, {@link
     * ItemTouchHelper#END}
     * <p>
     * Flags can be OR'd together to allow multiple directions.
     */
    public SwipeBuilder2 withDirections(int directionFlags) {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                                          ^^^^^^^^^^^^^^ definition local61
      return new SwipeBuilder2(recyclerView, makeMovementFlags(0, directionFlags));
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#`<init>`().
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                                           ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#makeMovementFlags#
//                                                                ^^^^^^^^^^^^^^ reference local61
    }
  }

  public static class SwipeBuilder2 {
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.

    private SwipeBuilder2(RecyclerView recyclerView,
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#`<init>`().
//                        ^^^^^^^^^^^^ reference _root_/
//                                     ^^^^^^^^^^^^ definition local62
        int movementFlags) {
//          ^^^^^^^^^^^^^ definition local63
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                        ^^^^^^^^^^^^ reference local62
      this.movementFlags = movementFlags;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#this.
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                         ^^^^^^^^^^^^^ reference local63
    }

    /**
     * Set the type of Epoxy model that is swipable. Use this if you only have one
     * swipable type.
     */
    public <U extends EpoxyModel> SwipeBuilder3<U> withTarget(Class<U> targetModelClass) {
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//                                                 ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().
//                                                            ^^^^^ reference java/lang/Class#
//                                                                  ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//                                                                     ^^^^^^^^^^^^^^^^ definition local64
      List<Class<? extends EpoxyModel>> targetClasses = new ArrayList<>(1);
//    ^^^^ reference java/util/List#
//         ^^^^^ reference java/lang/Class#
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^^^^ definition local65
//                                                      ^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                                                          ^^^^^^^^^ reference java/util/ArrayList#
      targetClasses.add(targetModelClass);
//    ^^^^^^^^^^^^^ reference local65
//                  ^^^ reference java/util/List#add().
//                      ^^^^^^^^^^^^^^^^ reference local64

      return new SwipeBuilder3<>(recyclerView, movementFlags, targetModelClass,
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`(). 1:24
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                                            ^^^^^^^^^^^^^^^^ reference local64
          targetClasses);
//        ^^^^^^^^^^^^^ reference local65
    }

    /**
     * Specify which Epoxy model types are swipable. Use this if you have more than one type that
     * is swipable.
     * <p>
     * If you only have one swipable type you should use {@link #withTarget(Class)}
     */
    public SwipeBuilder3<EpoxyModel> withTargets(
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTargets().
        Class<? extends EpoxyModel>... targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                     ^^^^^^^^^^^^^^^^^^ definition local66
      return new SwipeBuilder3<>(recyclerView, movementFlags, EpoxyModel.class,
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`(). 1:44
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                       ^^^^^ reference com/airbnb/epoxy/EpoxyModel#class.
          Arrays.asList(targetModelClasses));
//        ^^^^^^ reference java/util/Arrays#
//               ^^^^^^ reference java/util/Arrays#asList().
//                      ^^^^^^^^^^^^^^^^^^ reference local66
    }

    /**
     * Use this if all models in the controller should be swipable, and if there are multiple types
     * of models in the controller.
     * <p>
     * If you only have one model type you should use {@link #withTarget(Class)}
     */
    public SwipeBuilder3<EpoxyModel> forAllModels() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#forAllModels().
      return withTarget(EpoxyModel.class);
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^ reference com/airbnb/epoxy/EpoxyModel#class.
    }
  }

  public static class SwipeBuilder3<U extends EpoxyModel> {
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                                  ^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
    private final Class<U> targetModelClass;
//                ^^^^^ reference java/lang/Class#
//                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.
    private final List<Class<? extends EpoxyModel>> targetModelClasses;
//                ^^^^ reference java/util/List#
//                     ^^^^^ reference java/lang/Class#
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.

    private SwipeBuilder3(
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`().
        RecyclerView recyclerView, int movementFlags,
//      ^^^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^^ definition local67
//                                     ^^^^^^^^^^^^^ definition local68
        Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//               ^^^^^^^^^^^^^^^^ definition local69
//                                 ^^^^ reference java/util/List#
//                                      ^^^^^ reference java/lang/Class#
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                   ^^^^^^^^^^^^^^^^^^ definition local70

      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.
//                        ^^^^^^^^^^^^ reference local67
      this.movementFlags = movementFlags;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#this.
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
//                         ^^^^^^^^^^^^^ reference local68
      this.targetModelClass = targetModelClass;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#this.
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.
//                            ^^^^^^^^^^^^^^^^ reference local69
      this.targetModelClasses = targetModelClasses;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#this.
//         ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                              ^^^^^^^^^^^^^^^^^^ reference local70
    }

    /**
     * Set callbacks to handle swipe actions and lifecycle events.
     * <p>
     * You MUST implement {@link SwipeCallbacks#onSwipeCompleted(EpoxyModel, View, int, int)} to
     * remove the swiped item from your data and request a model build.
     * <p>
     * You can optionally implement the other callbacks to modify the view as it is being swiped.
     *
     * @return An {@link ItemTouchHelper} instance that has been initialized and attached to a
     * recyclerview. The touch helper has already been fully set up and can be ignored, but you may
     * want to hold a reference to it if you need to later detach the recyclerview to disable touch
     * events via setting null on {@link ItemTouchHelper#attachToRecyclerView(RecyclerView)}
     */
    public ItemTouchHelper andCallbacks(final SwipeCallbacks<U> callbacks) {
//         ^^^^^^^^^^^^^^^ reference _root_/
//                         ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#andCallbacks().
//                                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#
//                                                           ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                              ^^^^^^^^^ definition local71
      ItemTouchHelper itemTouchHelper =
//    ^^^^^^^^^^^^^^^ reference _root_/
//                    ^^^^^^^^^^^^^^^ definition local72
          new ItemTouchHelper(new EpoxyModelTouchCallback<U>(null, targetModelClass) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference `<init>`# 42:12
//            ^^^^^^^^^^^^^^^ reference _root_/
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local74 42:11
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.
//                                                                                   ^ definition local75 2:7
//                                                                                   ^ definition local76 2:13
//                                                                                     reference java/lang/ 2:2
//                                                                                     reference com/airbnb/epoxy/ 2:3
//                                                                                     reference java/lang/Class# 2:3
//                                                                                     reference com/airbnb/ 2:4
//                                                                                     reference com/airbnb/epoxy/EpoxyController# 2:13

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public int getMovementFlagsForModel(U model, int adapterPosition) {
//                     ^^^^^^^^^^^^^^^^^^^^^^^^ definition local77
//                                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                ^^^^^ definition local78
//                                                           ^^^^^^^^^^^^^^^ definition local79
              return movementFlags;
//                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            protected boolean isTouchableModel(EpoxyModel<?> model) {
//                            ^^^^^^^^^^^^^^^^ definition local80
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local81
              boolean isTargetType = targetModelClasses.size() == 1
//                    ^^^^^^^^^^^^ definition local82
//                                   ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                                                      ^^^^ reference java/util/List#size().
                  ? super.isTouchableModel(model)
//                  ^^^^^ reference local83
//                        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                         ^^^^^ reference local81
                  : targetModelClasses.contains(model.getClass());
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                                     ^^^^^^^^ reference java/util/List#contains().
//                                              ^^^^^ reference local81
//                                                    ^^^^^^^^ reference java/lang/Object#getClass().

              //noinspection unchecked
              return isTargetType && callbacks.isSwipeEnabledForModel((U) model);
//                   ^^^^^^^^^^^^ reference local82
//                                   ^^^^^^^^^ reference local71
//                                             ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#isSwipeEnabledForModel().
//                                                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                                        ^^^^^ reference local81
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onSwipeStarted(U model, View itemView, int adapterPosition) {
//                      ^^^^^^^^^^^^^^ definition local84
//                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                       ^^^^^ definition local85
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^ definition local86
//                                                                 ^^^^^^^^^^^^^^^ definition local87
              callbacks.onSwipeStarted(model, itemView, adapterPosition);
//            ^^^^^^^^^ reference local71
//                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeStarted().
//                                     ^^^^^ reference local85
//                                            ^^^^^^^^ reference local86
//                                                      ^^^^^^^^^^^^^^^ reference local87
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onSwipeProgressChanged(U model, View itemView, float swipeProgress,
//                      ^^^^^^^^^^^^^^^^^^^^^^ definition local88
//                                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                               ^^^^^ definition local89
//                                                      ^^^^ reference _root_/
//                                                           ^^^^^^^^ definition local90
//                                                                           ^^^^^^^^^^^^^ definition local91
                Canvas canvas) {
//              ^^^^^^ reference _root_/
//                     ^^^^^^ definition local92
              callbacks.onSwipeProgressChanged(model, itemView, swipeProgress, canvas);
//            ^^^^^^^^^ reference local71
//                      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeProgressChanged().
//                                             ^^^^^ reference local89
//                                                    ^^^^^^^^ reference local90
//                                                              ^^^^^^^^^^^^^ reference local91
//                                                                             ^^^^^^ reference local92
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onSwipeCompleted(U model, View itemView, int position, int direction) {
//                      ^^^^^^^^^^^^^^^^ definition local93
//                                       ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                         ^^^^^ definition local94
//                                                ^^^^ reference _root_/
//                                                     ^^^^^^^^ definition local95
//                                                                   ^^^^^^^^ definition local96
//                                                                                 ^^^^^^^^^ definition local97
              callbacks.onSwipeCompleted(model, itemView, position, direction);
//            ^^^^^^^^^ reference local71
//                      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeCompleted().
//                                       ^^^^^ reference local94
//                                              ^^^^^^^^ reference local95
//                                                        ^^^^^^^^ reference local96
//                                                                  ^^^^^^^^^ reference local97
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onSwipeReleased(U model, View itemView) {
//                      ^^^^^^^^^^^^^^^ definition local98
//                                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                        ^^^^^ definition local99
//                                               ^^^^ reference _root_/
//                                                    ^^^^^^^^ definition local100
              callbacks.onSwipeReleased(model, itemView);
//            ^^^^^^^^^ reference local71
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeReleased().
//                                      ^^^^^ reference local99
//                                             ^^^^^^^^ reference local100
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void clearView(U model, View itemView) {
//                      ^^^^^^^^^ definition local101
//                                ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                  ^^^^^ definition local102
//                                         ^^^^ reference _root_/
//                                              ^^^^^^^^ definition local103
              callbacks.clearView(model, itemView);
//            ^^^^^^^^^ reference local71
//                      ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#clearView().
//                                ^^^^^ reference local102
//                                       ^^^^^^^^ reference local103
            }
          });

      itemTouchHelper.attachToRecyclerView(recyclerView);
//    ^^^^^^^^^^^^^^^ reference local72
//                    ^^^^^^^^^^^^^^^^^^^^ reference attachToRecyclerView#
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.

      return itemTouchHelper;
//           ^^^^^^^^^^^^^^^ reference local72
    }
  }

  public abstract static class SwipeCallbacks<T extends EpoxyModel>
//                             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#
//                             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#`<init>`().
//                                            ^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
      implements EpoxySwipeCallback<T> {
//               ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxySwipeCallback#
//                                  ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeStarted(T model, View itemView, int adapterPosition) {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeStarted().
//                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                               ^^^^^ definition local104
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^^ definition local105
//                                                         ^^^^^^^^^^^^^^^ definition local106

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//              ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeProgressChanged().
//                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                       ^^^^^ definition local107
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^ definition local108
//                                                                   ^^^^^^^^^^^^^ definition local109
        Canvas canvas) {
//      ^^^^^^ reference _root_/
//             ^^^^^^ definition local110

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public abstract void onSwipeCompleted(T model, View itemView, int position, int direction);
//                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeCompleted().
//                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                          ^^^^^ definition local111
//                                                 ^^^^ reference _root_/
//                                                      ^^^^^^^^ definition local112
//                                                                    ^^^^^^^^ definition local113
//                                                                                  ^^^^^^^^^ definition local114

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeReleased(T model, View itemView) {
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeReleased().
//                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                ^^^^^ definition local115
//                                       ^^^^ reference _root_/
//                                            ^^^^^^^^ definition local116

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void clearView(T model, View itemView) {
//              ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#clearView().
//                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                          ^^^^^ definition local117
//                                 ^^^^ reference _root_/
//                                      ^^^^^^^^ definition local118

    }

    /**
     * Whether the given model should be swipable.
     * <p>
     * True by default. You may override this to toggle swipabaility for a model.
     */
    public boolean isSwipeEnabledForModel(T model) {
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#isSwipeEnabledForModel().
//                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                          ^^^^^ definition local119
      return true;
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public final int getMovementFlagsForModel(T model, int adapterPosition) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#getMovementFlagsForModel().
//                                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                              ^^^^^ definition local120
//                                                         ^^^^^^^^^^^^^^^ definition local121
      // Not used
      return 0;
    }
  }
}
