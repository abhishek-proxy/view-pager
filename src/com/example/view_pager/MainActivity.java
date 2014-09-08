package com.example.view_pager;

import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//import com.example.userlog.R;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
//import com.example.userlog.R;

public class MainActivity extends Activity {
	String strEmail;
	String strFirstName;
	String strLocation;
	int flag=0;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button but=(Button)findViewById(R.id.button1);
    but.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			doSocialNetworkinWithFacebook();
			flag=1;
		}
	});
    // start Facebook Login
    if(flag==1)
    {
    	Intent i=new Intent(getApplicationContext(),MainActivityto.class);
    	startActivity(i);
    }
   }

  

  @SuppressWarnings("deprecation")
	private void doSocialNetworkinWithFacebook()
  {Log.i("pos", "msg");
      // check for session 
       Session session=Session.getActiveSession();
       if (session != null && session.isOpened()) 
           {  Log.i("pos", "msg");
              // user is already login show
                  try
                      {
                          Session.OpenRequest request = new Session.OpenRequest(this);
                          request.setPermissions(Arrays.asList("email", "publish_actions"));
                      }
                  catch (Exception e)
                      {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                      }
               Request.executeMeRequestAsync(session, new Request.GraphUserCallback() 
                      {
                        // callback after Graph API response with user object

                        @Override
                        public void onCompleted(GraphUser user, Response response) 
                        {
                            if (user != null) 
                             {
                               //  Toast.makeText(activity, "Welcome  "+user.getName(), Toast.LENGTH_SHORT).show();
                                // publishFeedDialog(session);
                                  try
                                      {		Log.i("pos", "msg");
                                          	strFirstName = user.getFirstName().toString();
                                          	strLocation = user.getLocation().getProperty("name").toString();
                                          	strEmail = user.asMap().get("email").toString();

                                      }
                                  catch (Exception e)
                                      {
                                          // TODO Auto-generated catch block
                                          e.printStackTrace();
                                          strEmail="";
                                      }
                                  TextView welcome = (TextView) findViewById(R.id.welcome);
                                  welcome.setText(strEmail);
                              }
                        }
                  });

           }
       else
           {
               // user is not log in 
               //show  login screen

              // start Facebook Login

                  try
                      {
                          Session.OpenRequest request = new Session.OpenRequest(this);
                          request.setPermissions(Arrays.asList("email", "publish_actions"));
                      }
                  catch (Exception e)
                      {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                      }
               Session.openActiveSession(this, true, new Session.StatusCallback() 
               {

                   // callback when session changes state
                  public void call(final Session session, SessionState state, Exception exception) 
                  {
                      //session.openForRead(new Session.OpenRequest(this).setPermissions(Arrays.asList("email")));
           

                      if (session.isOpened()) 
                      {                               
                          // make request to the /me API

                          Request.executeMeRequestAsync(session, new Request.GraphUserCallback()

                              {
                                // callback after Graph API response with user object
                                @Override
                                public void onCompleted(GraphUser user, Response response) 
                                {
                                    if (user != null) 
                                     {

                                         //Toast.makeText(activity, "Welcome  "+user.getName(), Toast.LENGTH_SHORT).show();
                                        // publishFeedDialog(session);
                                         try
                                          {
                                                  strFirstName = user.getFirstName().toString();
                                                  strLocation = user.getLocation().getProperty("name").toString();
                                                  strEmail = user.asMap().get("email").toString();
                                          }
                                      catch (Exception e)
                                          {
                                              // TODO Auto-generated catch block
                                              e.printStackTrace();
                                              strEmail="";
                                          }

                                         TextView welcome = (TextView) findViewById(R.id.welcome);
                                         welcome.setText(strEmail);
                                      }
                                }
                          });

                      }
                      

                  }
                });
           }

  }
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
  }

}