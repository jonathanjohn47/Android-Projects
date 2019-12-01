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

public class AdapterCities extends RecyclerView.Adapter<AdapterCities.CityViewHolder> {

    private ArrayList<City> mListCities;


    public interface OnCityClickListener {
        public void onCityClick( City city, int position );
    }

    private OnCityClickListener mOnCityClickListener;

    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.mOnCityClickListener = onCityClickListener;
    }

    public AdapterCities(ArrayList<City> listCities ) {
        mListCities = listCities;
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        public TextView mTxtCityName;
        public ImageView mImgCity;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);

            mTxtCityName = itemView.findViewById( R.id.txtCityName);
            mImgCity = itemView.findViewById( R.id.imgCity );

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if( mOnCityClickListener != null ) {

                                mOnCityClickListener.onCityClick(
                                        mListCities.get( getAdapterPosition() ),
                                        getAdapterPosition()
                                );
                            }
                        }
                    }
            );
        }
    }

    @Override
    public int getItemCount() {
        Log.v("tag", "getItemCount() " + mListCities.size() );
        return mListCities.size();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from( parent.getContext()  )
                .inflate( R.layout.city, null );

        return new CityViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, final int position) {

        City city = mListCities.get( position );

        holder.mTxtCityName.setText( city.getName() );
        holder.mImgCity.setImageResource( city.getImageId() );

    }
}
