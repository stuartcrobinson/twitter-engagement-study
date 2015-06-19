import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class awefawefawef {

	/**
	 * @param args
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub
		
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("zYOpiD5Fv8cfr94S90SBrwnQk")
		  .setOAuthConsumerSecret("qK4xPV4zf3eYn0Bkqeo5WOdhmSB6iDqaYxMxCodLHCpkWIAtAS")
		  .setOAuthAccessToken("2446070082-v5TtCDouoiWYi61yRqP7O6t133GFMGANHPFuByd")
		  .setOAuthAccessTokenSecret("WftAemWS33fbPxjDzNEizMQzMTjo8OIFZuE6PG5qhbKRX");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		 // The factory instance is re-useable and thread safe.
//	    Twitter twitter = TwitterFactory.getSingleton();
	    Status status = twitter.updateStatus("twesdfsdfet");
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");
	    
	    

	}

}
