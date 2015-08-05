package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Application extends Controller
{

    public static Result index() throws  Exception
    {

        try
        {

            String url = "http://prsi.monster.com/query.ashx?rb=1&&loc=02115-20&cname=john%2520smith";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();


            //System.out.println(response.toString());
           XmlParser.parse(response.toString());
        }

        catch(Exception e)
        {
            System.out.println(e);
        }

        return ok(index.render("Hello"));
    }



}
