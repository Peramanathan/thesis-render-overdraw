/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.example.android.mobileperf.render;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;


/**
 * Fragment that encapsulates creating {@link Chat} objects and displaying them using a
 * {@link ListView} layout.
 * Creates seed data consisting of a handful of chats authored by a few authors.
 */
public class ChatsFragment extends Fragment {
    protected static int MILLISECONDS_PER_SECOND = 1000;
    protected static int SECONDS_PER_MINUTE = 60;

    public ChatsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create a list of chats and populate it with hardcoded data.
        ArrayList<Chat> chats = new ArrayList<Chat>();
        populateChats(chats);

        // Create the adapter that provides values to the UI Widgets.
        ChatAdapter adapter = new ChatAdapter(getActivity(), chats);

        View rootView = inflater.inflate(R.layout.fragment_chats, container, false);

        // Find the ListView that holds all the chat messages and attach it to the adapter,
        ListView listView = (ListView) rootView.findViewById(R.id.listview_chats);
        listView.setAdapter(adapter);

        return rootView;
    }

    private Date getTimeInPast(int minutesAgo) {
        return new Date(new Date().getTime() -
                (minutesAgo * SECONDS_PER_MINUTE * MILLISECONDS_PER_SECOND));
    }

    // Creates hardcoded chat objects.
    private void populateChats(ArrayList<Chat> chats) {
        Resources res = getResources();
        Droid prem = new Droid("prem", res.getColor(R.color.alex_color));
        Droid edith = new Droid("edith", res.getColor(R.color.joanna_color), R.drawable.edith);
        Droid subra = new Droid("subra", res.getColor(R.color.shailen_color),
                R.drawable.subhra);

        chats.add(new Chat(prem, "Edith ! I have attached the report in the mail, Plese have a look at it",
                getTimeInPast(15)));

        chats.add(new Chat(edith, "Prem ! Sure, I will get back to you once I've done  " +
                "Then you can forward it to your reviewer",
                getTimeInPast(11)));

        chats.add(new Chat(prem, "Thanks Edith   " +
                "I am also preparing source codes and I will send it to you later",
                getTimeInPast(9)));

        chats.add(new Chat(edith, "Report looks fine, correct typos and grammar " +
                "Marked sentences and paragraphs need to be rewritten clearly" +
                "Correct the report and forward it to your reviewer ! Good luck ",
                getTimeInPast(8)));

        chats.add(new Chat(prem, "Hi Subhra" +
                "I have sent a mail with my thesis report attached. Please have a look at it ",
                getTimeInPast(8)));

        chats.add(new Chat(subra, "Hi Prem, I will soon review your report ! Thanks ",
                getTimeInPast(7)));

        chats.add(new Chat(prem, "Thanks Subhra",
                getTimeInPast(6)));

        chats.add(new Chat(subra, "Prem, Please have a look at my comments and you can proceed with Thesis presentation " +
                "Good luck",
                getTimeInPast(4)));

        chats.add(new Chat(prem, "Thanks for your time Subhra " +
                "I have read the comments and corrected the report accordingly " +
                "I will wait for the comments on presentation day too " +
                "Then I will send final version  ",
                getTimeInPast(3)));
    }
}