package in.bitcode.recyclerview1;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterCities extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<City> mListCities;
    private ArrayList<String> mListStates;

    public static final int VIEW_TYPE_STATE = 0, VIEW_TYPE_CITY = 1;


    //Listener for City
    interface OnCityClickListener {
        public void onCityClick( int position, City city );
    }
    private OnCityClickListener mOnCityClickListener;

    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.mOnCityClickListener = onCityClickListener;
    }

    //Listener for State
    interface OnStateClickListener {
        public void onStateClick( int position, String state );
    }
    private OnStateClickListener mOnStateClickListener;

    public void setOnStateClickListener(OnStateClickListener onStateClickListener) {
        this.mOnStateClickListener = onStateClickListener;
    }

    public AdapterCities(ArrayList<City> listCities, ArrayList<String> listStates) {
        mListCities = listCities;
        mListStates = listStates;
    }

    class StateViewHolder extends RecyclerView.ViewHolder {

        public TextView mTxtState;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtState = (TextView) itemView;

            mTxtState.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if( mOnStateClickListener != null ) {
                                mOnStateClickListener.onStateClick( getAdapterPosition() / 4, mListStates.get( getAdapterPosition() / 4) );
                            }

                        }
                    }
            );
        }
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        public TextView mTxtCityName;
        public ImageView mImgCity;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);

            mTxtCityName = itemView.findViewById(R.id.txtCityName);
            mImgCity = itemView.findViewById(R.id.imgCity);

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if( mOnCityClickListener != null ) {

                                mOnCityClickListener.onCityClick(
                                        getAdapterPosition() - ( 1 + getAdapterPosition()/4 ),
                                        mListCities.get( getAdapterPosition() - ( 1 + getAdapterPosition()/4 ))
                                );

                            }

                        }
                    }
            );

        }
    }

    @Override
    public int getItemCount() {
        Log.v("tag", "getItemCount() " + mListCities.size());
        return mListCities.size() + mListStates.size();
    }


    @Override
    public int getItemViewType(int position) {

        if (position % 4 == 0) {
            return VIEW_TYPE_STATE;
        }

        return VIEW_TYPE_CITY;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if( viewType == VIEW_TYPE_STATE ) {

            TextView txtState = new TextView(parent.getContext());
            txtState.setTextSize(50);
            txtState.setPadding(20, 10, 10, 10);
            return new StateViewHolder(txtState);
        }


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city, null);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof CityViewHolder) {

            CityViewHolder cityViewHolder = (CityViewHolder) holder;

            City city = mListCities.get(position - ( 1 + ( position/4 ) ));

            cityViewHolder.mTxtCityName.setText(city.getName());
            cityViewHolder.mImgCity.setImageResource(city.getImageId());
        }

        if (holder instanceof StateViewHolder) {

            StateViewHolder stateViewHolder = (StateViewHolder) holder;
            stateViewHolder.mTxtState.setText(mListStates.get(position/4));
        }

    }
}
