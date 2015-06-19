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

package twitter4j.examples.user;

import twitter4j.*;

/**
 * Looks up users.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class LookupUsers {
    /**
     * Usage: java twitter4j.examples.user.LookupUsers [screen name[,screen name..]]
     *
     * @param args message
     */
    public static void main(String[] args) {
//        if (args.length < 1) {
//            System.out.println(
//                    "Usage: java twitter4j.examples.user.LookupUsers [screen name[,screen name..]]");
//            System.exit(-1);
//        }
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            String [] users2 = {"wearebombadil,stuartclifford"};
            
            User u = twitter.showUser("wearebombadil");
            System.out.println(u.getFriendsCount() + " friends");
            System.out.println(u.getStatusesCount() + " statuses");
            System.out.println(u.getCreatedAt() + " date");
            
            
            ResponseList<User> users = twitter.lookupUsers(users2);
            for (User user : users) {
                if (user.getStatus() != null) {
                    System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
                    System.out.println(user.getFriendsCount() + " friends");
                    System.out.println(user.getStatusesCount() + " statuses");
                    System.out.println(user.getCreatedAt() + " date");
                    System.out.println(user.getFollowersCount() + " followers");
                    System.out.println(user.getURLEntity() + " url");
                    
                    
                } else {
                    // the user is protected
                    System.out.println("@" + user.getScreenName());
                }
            }
            System.out.println("Successfully looked up users [" + args[0] + "].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to lookup users: " + te.getMessage());
            System.exit(-1);
        }
    }
}
