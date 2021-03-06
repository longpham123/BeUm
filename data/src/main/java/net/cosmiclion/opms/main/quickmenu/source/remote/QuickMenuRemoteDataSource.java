package net.cosmiclion.opms.main.quickmenu.source.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import net.cosmiclion.opms.login.model.ResponseData;
import net.cosmiclion.opms.main.purchase.service.PurchaseService;
import net.cosmiclion.opms.main.quickmenu.QuickMenuDataSource;
import net.cosmiclion.opms.network.retrofit2.ApiClient;
import net.cosmiclion.opms.utils.Debug;

import retrofit2.Call;
import retrofit2.Callback;

import static com.google.common.base.Preconditions.checkNotNull;

public class QuickMenuRemoteDataSource implements QuickMenuDataSource {
    private String TAG = getClass().getSimpleName();
    private static QuickMenuRemoteDataSource INSTANCE = null;
    private Context mContext;

    public static QuickMenuRemoteDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new QuickMenuRemoteDataSource(context);
        }
        return INSTANCE;
    }

    private QuickMenuRemoteDataSource(@NonNull Context context) {
        this.mContext = checkNotNull(context);
    }

    @Override
    public void getBooksPurchaseResponse(@NonNull String token,
                                         @NonNull final LoadPurchaseCallback callback) {
        Debug.i(TAG, "===getBooksPurchaseResponse===");

        PurchaseService purchaseService = ApiClient.getClient(mContext).create(PurchaseService.class);

        final Call<ResponseData> call = purchaseService.getBookPurchaseInfo(token);

        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call,
                                   retrofit2.Response<ResponseData> response) {
                callback.onBooksPurchaseLoaded(response.body());
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Debug.i(TAG, "Something went wrong: " + t.getMessage());
                callback.onDataNotAvailable(t.getMessage());
            }
        });
    }
}
