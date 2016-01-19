package com.idyll.testapp.activity;

import android.app.Activity;

/**
 * @author shibo
 * @packageName com.idyll.testapp.activity
 * @description
 * @date 16/1/19
 */
public class DragGridViewActivity extends Activity {
//    private List<HashMap<String, Object>> mDataList = new ArrayList<>();
//    private DragAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_drag_grid_view);
//
//        init();
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (mAdapter.isEdit()) {
//                mAdapter.setEdit(false);
//                return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    private void init() {
//        DragGridView mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
//        for (int i = 0; i < 30; i++) {
//            HashMap<String, Object> item = new HashMap<String, Object>();
//            int id = ((i&1) == 0) ? R.mipmap.ic_launcher : R.mipmap.icon_notification_cup;
//            item.put("item_image", id);
//            item.put("item_text", "item " + Integer.toString(i));
//            mDataList.add(item);
//        }
//
//        mAdapter = new DragAdapter(this, mDataList);
//        mAdapter.setOnDragClickListener(mDragClickListener);
//
//        mDragGridView.setAdapter(mAdapter);
//        mDragGridView.setOnChangeListener(mChanageListener);
//    }
//
//    private DragGridView.OnChanageListener mChanageListener = new DragGridView.OnChanageListener() {
//
//        @Override
//        public void onStartDrag() {
//            LogUtil.defaultLog("on start drag");
//            mAdapter.setEdit(true);
//        }
//
//        @Override
//        public void onStopDrag() {
//            LogUtil.defaultLog("on stop drag");
//            mAdapter.notifyDataSetChanged();
//        }
//
//        @Override
//        public void onChange(int from, int to) {
//            LogUtil.defaultLog("on change, "+from+" -> " +to);
//            HashMap<String, Object> temp = mDataList.get(from);
//
//            if(from < to){
//                for(int i=from; i<to; i++){
//                    Collections.swap(mDataList, i, i + 1);
//                }
//            }else if(from > to){
//                for(int i=from; i>to; i--){
//                    Collections.swap(mDataList, i, i-1);
//                }
//            }
//
//            mDataList.set(to, temp);
//            mAdapter.notifyDataSetChanged();
//        }
//    };
//
//    private DragAdapter.OnDragClickListener mDragClickListener = new DragAdapter.OnDragClickListener() {
//        @Override
//        public void onIcon(int position) {
//            LogUtil.defaultLog("onIcon(), position: " + position);
//            Toast.makeText(getApplicationContext(),
//                    "onIcon(), pos: " + position, Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onDelete(int position) {
//            LogUtil.defaultLog("onDelete(), position: " + position);
//            mDataList.remove(position);
//            if (mDataList.size() <= 0) {
//                mAdapter.setEdit(false);
//            }
//            mAdapter.notifyDataSetChanged();
//        }
//    };
}
