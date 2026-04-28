package DESIGN.DesginTwitter;
import java.util.*;

// linkedList to keep most recent at top means add at head O(1) insertion
class Twitter {
    private static class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id , int time) {
            this.id = id;
            this.time = time;
        }
    }
    private Map<Integer , Set<Integer>> followMap;
    private Map<Integer , Tweet> tweetMap;
    private int timeStamp;

    Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        Tweet newTweet = new Tweet(tweetId , timeStamp);
        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId , newTweet);
    }



    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> recent = new PriorityQueue<>((a , b) -> b.time - a.time);


        if (tweetMap.containsKey(userId)) {
            recent.offer(tweetMap.get(userId));
        }

        Set<Integer> followers = followMap.get(userId);
        if (followers != null) {
            for (int followee : followMap.get(userId)) {
                if (tweetMap.containsKey(followee)) {
                    recent.offer(tweetMap.get(followee));
                }
            }
        }



        int count = 0;

        while (!recent.isEmpty() && count < 10) {
            Tweet current = recent.poll();
            result.add(current.id);

            if (current.next != null) {
                recent.offer(current.next);
            }
            count++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        followMap.putIfAbsent(followerId , new HashSet<>());
        followMap.get(followerId).add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        System.out.println("User 1 posts tweet 5");
        twitter.postTweet(1, 5);

        System.out.println("Feed of user 1: " + twitter.getNewsFeed(1));
        // Expected: [5]

        System.out.println("User 1 follows user 2");
        twitter.follow(1, 2);

        System.out.println("User 2 posts tweet 6");
        twitter.postTweet(2, 6);

        System.out.println("Feed of user 1: " + twitter.getNewsFeed(1));
        // Expected: [6, 5]

        System.out.println("User 1 unfollows user 2");
        twitter.unfollow(1, 2);

        System.out.println("Feed of user 1: " + twitter.getNewsFeed(1));
        // Expected: [5]


        // 🔥 Additional Testing
        System.out.println("\nMore testing:");

        twitter.postTweet(1, 7);
        twitter.postTweet(1, 8);
        twitter.postTweet(2, 9);
        twitter.follow(1, 2);

        System.out.println("Feed of user 1: " + twitter.getNewsFeed(1));
        // Expected: [9,8,7,5]


        int  x = 0;
        int y = 1;

        int a = 10 , b = 16;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println(a);

    }
}


