package johnkagga.me.celestini;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.List;

import johnkagga.me.celestini.data.ClientContactInformation;

/**
 * Created by jokamjohn on 1/12/2016.
 */
public class SyncAdapter extends RecyclerView.Adapter<SyncAdapter.SyncViewHolder> {

    private List<ClientContactInformation> mInformationList;
    Context mContext;

    public SyncAdapter(Context context, List<ClientContactInformation> informationList) {
        mInformationList = informationList;
        mContext = context;
    }

    @Override
    public SyncViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sync_list_item, parent, false);
        SyncViewHolder viewHolder = new SyncViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SyncViewHolder holder, int position) {
        holder.bindData(mInformationList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mInformationList.size();
    }

    public class SyncViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mClientName;
        public TextView mClientLocation;

        public SyncViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.list_image);
            mClientName = (TextView) itemView.findViewById(R.id.client_name);
            mClientLocation = (TextView) itemView.findViewById(R.id.client_village);
        }

        public void bindData(ClientContactInformation information, int position) {
            TextDrawable imageName = TextDrawable.builder()
                    .buildRound(information.getFirstName().substring(0, 1), Color.RED);

//            mImageView.setImageDrawable(imageName);
            mClientName.setText(information.getName());
            mClientLocation.setText(information.getPhysicalLocation());

            if ((position >= 2 && position < 4) || position == 6 || position == 7 || position == 12) {
                mImageView.setColorFilter(mContext.getResources().getColor(R.color.colorAccent));

            }
        }
    }
}
