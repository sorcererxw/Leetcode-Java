package _355_Design_Twitter

/**
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
*/

type Tweet struct {
	ID   int
	User int
}

type Twitter struct {
	Tweets   []Tweet
	Followee map[int]map[int]struct{}
}

/** Initialize your data structure here. */
func Constructor() Twitter {
	return Twitter{
		Tweets:   make([]Tweet, 0),
		Followee: make(map[int]map[int]struct{}),
	}
}

/** Compose a new tweet. */
func (t *Twitter) PostTweet(userId int, tweetId int) {
	t.Tweets = append(t.Tweets, Tweet{
		ID:   tweetId,
		User: userId,
	})
}

/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
func (t *Twitter) GetNewsFeed(userId int) []int {
	feed := make([]int, 0, 10)
	for i := len(t.Tweets) - 1; i >= 0; i-- {
		if userId == t.Tweets[i].User {
			feed = append(feed, t.Tweets[i].ID)
		} else if _, ok := t.Followee[userId][t.Tweets[i].User]; ok {
			feed = append(feed, t.Tweets[i].ID)
		}
		if len(feed) >= 10 {
			break
		}
	}
	return feed
}

/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
func (t *Twitter) Follow(followerId int, followeeId int) {
	if t.Followee[followerId] == nil {
		t.Followee[followerId] = make(map[int]struct{})
	}
	t.Followee[followerId][followeeId] = struct{}{}
}

/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
func (t *Twitter) Unfollow(followerId int, followeeId int) {
	if t.Followee[followerId] == nil {
		return
	}
	delete(t.Followee[followerId], followeeId)
}

/**
 * Your Twitter object will be instantiated and called as such:
 * obj := Constructor();
 * obj.PostTweet(userId,tweetId);
 * param_2 := obj.GetNewsFeed(userId);
 * obj.Follow(followerId,followeeId);
 * obj.Unfollow(followerId,followeeId);
 */
