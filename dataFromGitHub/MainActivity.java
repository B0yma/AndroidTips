
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }


        });
        
       

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(https://raw.githubusercontent.com/B0yma/photoframe/master))
                .build();

        ImageFrameInterface imageFrameInterface = restAdapter.create(ImageFrameInterface.class);
        imageFrameInterface.getStreams(new Callback<List<Imageframe>>() {
            @Override
            public void success(List<Imageframe> imageframes, Response response) {

                if(imageframes == null || imageframes.isEmpty())
                    return;

                for(Imageframe imageframe:imageframes){
                    Log.e("lel",imageframe.getCropedimg_link());
                }
            }

            @Override
            public void failure(RetrofitError error) {

                Log.e("azaza","Retrofit error" + error.getMessage());
            }
        });
    }

}

