package id.arieridwan.mycommerce.api;

import id.arieridwan.mycommerce.model.DataModel;
import id.arieridwan.mycommerce.model.DetailModel;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by root on 06/05/16.
 */
public interface DataAPI {
    @GET("/apiecommerce/public/index.php/list")
    void getData(Callback<DataModel> cb);
    @GET("/apiecommerce/public/index.php/list/{id}")
    public void getDetail(@Path("id") String id,Callback<DetailModel> response);
}
