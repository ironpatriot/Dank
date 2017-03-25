package me.saket.dank.ui.subreddits;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;

import me.saket.dank.data.RedditLink;

/**
 * Android doesn't like activities that have transparent background, especially if it's the launcher activity.
 * Strange behaviors noticed so far were:
 * <p>
 * - Double tapping on a URL would take user to the home.
 * - Opening a chrome custom tab would leak the home-screen during its entry animation.
 *
 * This Activity simply exists so that a different theme can be used in the manifest.
 */
public class SubredditActivityWithTransparentWindowBackground extends SubredditActivity {

    /**
     * @param expandFromShape The initial shape from where this Activity will begin its entry expand animation.
     */
    public static void start(Context context, RedditLink.Subreddit subredditLink, Rect expandFromShape) {
        Intent intent = new Intent(context, SubredditActivityWithTransparentWindowBackground.class);
        addStartExtrasToIntent(subredditLink, expandFromShape, intent);
        context.startActivity(intent);
    }

}
