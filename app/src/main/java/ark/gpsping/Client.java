package ark.gpsping;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client extends AsyncTask<Void,Void,BufferedWriter>{

    private Socket client = null;
    private OutputStreamWriter os = null;
    private String host;
    private int soc;
    private PrintWriter out ;
    public static Context c;
    Client(Context _c,String _host, int _socket){
        c = _c;
        host = _host;
        soc = _socket;
    }

    @Override
    protected BufferedWriter doInBackground(Void... voids) {
        BufferedWriter bw;
        bw = null;
        try {
            client = new Socket(host, soc);
            os = new OutputStreamWriter(
                    client.getOutputStream(), StandardCharsets.UTF_8);
            out = new PrintWriter(client.getOutputStream(), true);
            bw = new BufferedWriter(out);
             Log.d("Client", "Successfully Excuted");
        }catch (IOException ignored) {

        }
        return bw;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(BufferedWriter bufferedWriter) {
        super.onPostExecute(bufferedWriter);
    }
}
