package in.codepeaker.gradlejoke;

import java.util.Random;

public class JokeTeller {

    private Random random;
    private String[] jokeStrings;

    public JokeTeller() {
        random = new Random();
        jokeStrings = new String[]{
                "Can a kangaroo jump higher than a house? Of course, a house doesn't jump at all."
                , "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\nDoctor: \"Nine.\""
                , "A man asks a farmer near a field, \"Sorry sir, would you mind if I crossed your field instead of going around it? You see, I have to catch the 4:23 train.\"\n" +
                "The farmer says, \"Sure, go right ahead. And if my bull sees you, you'll even catch the 4:11 one.\""
                , "Anton, do you think I'm a bad mother?\nMy name is Paul."
                , "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away."
                , "Mother: \"How was school today, Patrick?\"\n" +
                "Patrick: \"It was really great mum! Today we made explosives!\"\n" +
                "Mother: \"Ooh, they do very fancy stuff with you these days. And what will you do at school tomorrow?\"\n" +
                "Patrick: \"What school?\""
                , "Police officer: \"Can you identify yourself, sir?\" \n" +
                "Driver pulls out his mirror and says: \"Yes, it's me.\""
                , "Some nice Chinese couple gave me a very good camera down by the Washington Monument. I didn't really understand what they were saying, but it was very nice of them."
                , "A wife goes to consult a psychiatrist about her husband: \"My husband is acting so weird. He drinks his morning coffee and then he goes and eats the mug! He only leaves the handle!\" \n" +
                "Psychiatrist: \"Yes, that is weird. The handle is the best part.\""
                , "A wife complains to her husband: \"Just look at that couple down the road, how lovely they are. He keeps holding her hand, kissing her, holding the door for her, why can't you do the same?\"\n" +
                "The husband: \"Are you mad? I barely know that woman!\""
                , "Patient: Oh doctor, I'm just so nervous. This is my first operation.\n" +
                "Doctor: Don't worry. Mine too."
                , "Mr. Smith: \"Doctor, you remember this strengthening solution you prescribed me yesterday?\"\n" +
                "Doctor: \"Yes, what's the matter?\"\n" +
                "Mr. Smith: \"I would like to use it but I can't open the bottle!\""
                , "Why do women live on average two years longer? \n" +
                "Because the time they spend parking doesn't count."
                , "Patient: Doctor help me please, every time I drink a cup of coffee I get this intense stinging in my eye.\n" +
                "Doctor: I suggest you remove the spoon before drinking."
                , "I can't believe I forgot to go to the gym today. That's 7 years in a row now."
        };
    }


    public String tellAJoke() {
        return jokeStrings[random.nextInt(14)];
    }
}
