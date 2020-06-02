package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop,mButtonBottom;
    private int mStoryIndex=0;
    private int mStory,mAns1,mAns2;

    private Story mStoryBank[] = new Story[]{
            new Story(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new Story(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new Story(R.string.T4_End,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T5_End,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T6_End,R.string.T1_Ans1,R.string.T1_Ans2)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState !=null){
            mStoryIndex =savedInstanceState.getInt("StoryState");
        }
        else
        {
            mStoryIndex =0;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom  = (Button) findViewById(R.id.buttonBottom);

        mStory = mStoryBank[mStoryIndex].getStoryID();
        mStoryTextView.setText(mStory);
        //
        mAns1 = mStoryBank[mStoryIndex].getAns1();
        mButtonTop.setText(mAns1);
        //
        mAns2 = mStoryBank[mStoryIndex].getAns2();
        mButtonBottom.setText(mAns2);





        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex==0||mStoryIndex==1){
                    mStoryIndex = 2;
                    updateStory();

                }
                else if(mStoryIndex==2){
                    mStoryIndex= 5;
                    updateStory();
                }


            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex==0){
                    mStoryIndex = 1;
                    updateStory();
                }
                else if (mStoryIndex==1) {
                    mStoryIndex = 3;
                    updateStory();
                }
                else if(mStoryIndex == 2){
                    mStoryIndex = 4;
                    updateStory();
                }

            }
        });


    }

    private void updateStory(){
        if(mStoryIndex == 3||mStoryIndex == 4||mStoryIndex == 5){
            mStory = mStoryBank[mStoryIndex].getStoryID();
            mStoryTextView.setText(mStory);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);

        }
        else {
            mStory = mStoryBank[mStoryIndex].getStoryID();
            mStoryTextView.setText(mStory);

            mAns1 = mStoryBank[mStoryIndex].getAns1();
            mButtonTop.setText(mAns1);

            mAns2 = mStoryBank[mStoryIndex].getAns2();
            mButtonBottom.setText(mAns2);


        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryState",mStoryIndex);
    }
}
