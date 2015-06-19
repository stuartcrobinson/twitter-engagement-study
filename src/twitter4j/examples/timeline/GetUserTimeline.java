/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter4j.examples.timeline;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class GetUserTimeline {
	/**
	 * Usage: java twitter4j.examples.timeline.GetUserTimeline
	 *
	 * @param args String[]
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {
		// gets Twitter instance with default credentials

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("zYOpiD5Fv8cfr94S90SBrwnQk")
		.setOAuthConsumerSecret("qK4xPV4zf3eYn0Bkqeo5WOdhmSB6iDqaYxMxCodLHCpkWIAtAS")
		.setOAuthAccessToken("2446070082-v5TtCDouoiWYi61yRqP7O6t133GFMGANHPFuByd")
		.setOAuthAccessTokenSecret("WftAemWS33fbPxjDzNEizMQzMTjo8OIFZuE6PG5qhbKRX");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		List<Status> statuses;
		String user;
		//            if (args.length == 0) {
		//                user = "wearebombadil";
		////                statuses = twitter.getUserTimeline(user, new Paging(1, 200));
		//            } else {
		//                user = twitter.verifyCredentials().getScreenName();
		//                statuses = twitter.getUserTimeline();
		//            }

		user = "wearebombadil";
		//System.out.println("Showing @" + user + "'s user timeline.");
		//System.out.println("contained_media,contained_link,num_interactions,");

		SimpleDateFormat sdf = new SimpleDateFormat("EEE");
		Map<String, Integer []> m = new TreeMap<String, Integer []>();

//		for (int p = 1; p <= 24; p++){
//			for (int q = 0; q <= 5; q++){
//				m.put(String.format("%02d", p) + ":" + String.format("%d", q) , new Integer[]{0,0});
//			}
//		}


		int i = 0;
		String c = " ";
		for (int j = 1; j <= 20; j++){
			statuses = twitter.getUserTimeline(user, new Paging(j, 99));
			for (Status status : statuses) {
				if (!status.isRetweet()){

					String key = sdf.format(status.getCreatedAt());//.substring(0, 4);
					Integer interactions = status.getFavoriteCount() + status.getRetweetCount();
					Integer [] ar;
					if (m.containsKey(key)){
						//System.out.println(key + " contained! with " + interactions + " interactions");
						ar = m.get(key);
						ar[0]++;
						ar[1] += interactions;
					}
					else {
						ar = new Integer []{1, interactions};
					}
					m.put(key, ar);

					i++;
				}
			}
		}
		for (String key1 : m.keySet()){
			System.out.println(key1 + " " + m.get(key1)[0] + " " + m.get(key1)[1]);
		}
	}

}


//System.out.print(i);
//System.out.print(c);
//System.out.print(  sdf.format(status.getCreatedAt()) );
//System.out.print(c);
//System.out.print(status.getFavoriteCount() + status.getRetweetCount());
//System.out.print(c);
//System.out.print(status.getText());
//System.out.print("\n");

//				System.out.println(c);
//				System.out.println("     " + status.getUserMentionEntities().length + " num users mentioned in post");
//				System.out.println("     " + status.getFavoriteCount() + " num favorited");
//				System.out.println("     " + status.getRetweetCount() + " num num retweeted");
//				System.out.println("     " + status.isRetweet() + " is retweet?");
//				System.out.println("     " + status.getHashtagEntities().length + " num hashtags");
//				System.out.println("     " + status.getURLEntities().length + " num urls");
//				System.out.println("     " + (status.getMediaEntities().length > 0 ? 1 : 0) + " num media entities");
//				System.out.println(status.getSource() + " --source");
//				System.out.println(status.toString() + " toSTring");
