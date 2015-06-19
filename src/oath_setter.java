import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class oath_setter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		

		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("zYOpiD5Fv8cfr94S90SBrwnQk")
		  .setOAuthConsumerSecret("qK4xPV4zf3eYn0Bkqeo5WOdhmSB6iDqaYxMxCodLHCpkWIAtAS")
		  .setOAuthAccessToken("2446070082-v5TtCDouoiWYi61yRqP7O6t133GFMGANHPFuByd")
		  .setOAuthAccessTokenSecret("WftAemWS33fbPxjDzNEizMQzMTjo8OIFZuE6PG5qhbKRX");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		

	}

}
