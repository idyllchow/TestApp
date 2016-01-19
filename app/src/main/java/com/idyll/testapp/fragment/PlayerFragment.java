package com.idyll.testapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idyll.testapp.R;
import com.idyll.testapp.adapter.LeftDragAdapter;
import com.idyll.testapp.bean.PlayerBean;
import com.idyll.testapp.view.DragGridView;
import com.idyll.testapp.view.PlayerTextItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shibo
 * @packageName com.idyll.testapp.fragment
 * @description
 * @date 16/1/18
 */
public class PlayerFragment extends Fragment {

    private DragGridView mDragLeftGridView;
    private LeftDragAdapter mDragLeftAdapter;
    //队员
    private ArrayList<PlayerTextItem> mItems = new ArrayList<>();
    private List<HashMap<String, Object>> mDataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, null, false);
        mDragLeftGridView = (DragGridView) view.findViewById(R.id.gv_player);

        for(int i = 0; i < 11; i++) {
            mItems.add(new PlayerTextItem(new PlayerBean(i + ""), 0, true));
        }
        int size = mItems.size();
        for (int i = size ; i < 20; i++) {
            mItems.add(new PlayerTextItem(new PlayerBean("-1"), 0, true));
        }

        mDragLeftAdapter = new LeftDragAdapter(getActivity(), mItems);
        mDragLeftGridView.setAdapter(mDragLeftAdapter);

        return view;
    }

//    private void initAnimate() {
//        mDragLeftGridView.setOnSwapItemCallback(new DragGridView.OnSwapItemCallback() {
//            @Override
//            public int onSwapItem(int moveX, int moveY, int oldPos) {
//                LogUtil.defaultLog("onSwapItem() moveX: " + moveX + ", moveY: " + moveY + ", oldPos: " + oldPos);
//                if (!mAnimationEnd) {
//                    return AdapterView.INVALID_POSITION;
//                }
//                final int left = mDragRightGridView.getLeft();
//                int adjustMoveX = moveX - left;
//                final int newPos = mDragRightGridView.pointToPosition(adjustMoveX, moveY);
//                if (newPos != AdapterView.INVALID_POSITION && mAnimationEnd) {
//                    swapLeftToRight(oldPos, newPos);
//                }
//                return newPos;
//            }
//
//            @Override
//            public void onSwapAnimate(int newPos, int oldPos, View oldView) {
//                if (null != mLeftItems.get(oldPos) && null != oldView && mAnimationEnd) {
//                    View newView = mDragRightGridView.getChildAt(newPos - mDragRightGridView.getFirstVisiblePosition());
//                    if (null != newView) {
//                        if (StatsConstants.TEMP_PLAYER == mLeftItems.get(oldPos).shirt_number) {
//                            mAnimateTv.setText("X");
//                        } else {
//                            mAnimateTv.setText(mLeftItems.get(oldPos).shirt_number + "");
//                        }
//                        final int left = mDragRightGridView.getLeft();
//                        final int newX = newView.getLeft() + left;
//                        final int newY = newView.getTop();
//                        final int oldX = oldView.getLeft();
//                        final int oldY = oldView.getTop();
//
//                        swapAnimate(oldView, newX, oldX, newY, oldY);
//                    }
//                }
//            }
//
//            @Override
//            public boolean checkHasPosition() {
//                for (PlayerTextItem player : mRightItems) {
//                    if (null == player) {
//                        return true;
//                    }
//                }
//                return false;
//            }
//
//            @Override
//            public void onItemClick(int clickedPos, final View oldView) {
//                LogUtil.defaultLog("mDragLeftGridView onItemClick() clickedPos: " + clickedPos);
////                ((StatsOperateActivity) getActivity()).hideTipView();
//                PlayerTextItem player = mLeftItems.get(clickedPos);
//                for (int i = 0, len = mRightItems.size(); i < len; i++) {
//                    if (null == mRightItems.get(i)) {
//                        mRightItems.set(i, player);
//                        final int newPos = i;
//                        if (StatsConstants.TEMP_PLAYER == player.shirt_number) {
//                            mAnimateTv.setText("X");
//                        } else {
//                            mAnimateTv.setText(player.shirt_number + "");
//                        }
//                        final ViewTreeObserver observer = mDragRightGridView.getViewTreeObserver();
//                        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//
//                            @Override
//                            public boolean onPreDraw() {
//                                observer.removeOnPreDrawListener(this);
//                                final View newView = mDragRightGridView.getChildAt(newPos - mDragRightGridView.getFirstVisiblePosition());
//                                if (null != newView) {
//                                    final int left = mDragRightGridView.getLeft();
//                                    final int newX = newView.getLeft() + left;
//                                    final int newY = newView.getTop();
//                                    final int oldX = oldView.getLeft();
//                                    final int oldY = oldView.getTop();
//                                    if (DEBUG) {
//                                        LogUtils.e(TAG, "newX: " + newX + ", newY: " + newY + ", oldX: " + oldX + ", oldY: " + oldY);
//                                    }
//                                    swapAnimate(newView, oldX, newX, oldY, newY);
//                                }
//                                return true;
//                            }
//                        });
//
//                        mLeftItems.set(clickedPos, null);
//                        mDragLeftAdapter.notifyDataSetChanged();
//                        mDragRightAdapter.notifyDataSetChanged();
//                        break;
//                    }
//                }
//            }
//        });
//    }
//
//    private boolean mAnimationEnd = true;
//
//    private void swapAnimate(final View view, int newX, int oldX, int newY, int oldY) {
//        view.setVisibility(View.INVISIBLE);
//        mAnimateView.setVisibility(View.VISIBLE);
//        AnimatorSet resultSet = createXYAnimations(mAnimateView, newX, oldX, newY, oldY);
//        resultSet.setDuration(300);
//        resultSet.setInterpolator(new AccelerateDecelerateInterpolator());
//        resultSet.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                mAnimationEnd = false;
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mAnimationEnd = true;
//                mAnimateView.setVisibility(View.GONE);
//                view.setVisibility(View.VISIBLE);
//            }
//        });
//        resultSet.start();
//    }
//
//    private void swapRightToLeft(int oldPosition, int newPosition) {
//        PlayerTextItem oldItem = mRightItems.get(oldPosition);
//        PlayerTextItem newItem = mLeftItems.get(newPosition);
//        mLeftItems.set(newPosition, oldItem);
//        mRightItems.set(oldPosition, newItem);
//        mDragLeftAdapter.notifyDataSetChanged();
//    }
//
//    private void swapLeftToRight(int oldPosition, int newPosition) {
//        PlayerTextItem oldItem = mLeftItems.get(oldPosition);
//        PlayerTextItem newItem = mRightItems.get(newPosition);
//        mRightItems.set(newPosition, oldItem);
//        mLeftItems.set(oldPosition, newItem);
//        mDragRightAdapter.notifyDataSetChanged();
//    }
//
//    /**
//     * 创建移动动画
//     */
//    private AnimatorSet createXYAnimations(View view, float startX,
//                                           float endX, float startY, float endY) {
//        ObjectAnimator animX = ObjectAnimator.ofFloat(view, "x",
//                startX, endX);
//        ObjectAnimator animY = ObjectAnimator.ofFloat(view, "y",
//                startY, endY);
//        AnimatorSet animSetXY = new AnimatorSet();
//        animSetXY.playTogether(animX, animY);
//        return animSetXY;
//    }
}
