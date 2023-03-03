package TemplateMethod;

import java.util.ArrayList;
import java.util.List;

public class Seiska extends Game {

    private String[][] cards = new String[13][4]; //individual cards
    private String[] deck = new String[52];  //deck of cards

    private int winner;

    private int initIndex = 0;

    private int cardIndex = 0;
    private ArrayList<String> middlePile = new ArrayList<>(); //cards put in the middle

    private ArrayList<List<String>> playerHands; //cards the players are holding


    void initializeGame() {
        //initialize a deck of cards
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                switch (j){
                    case 0:
                        cards[i][j] = "Hertta ";
                        break;
                    case 1:
                        cards[i][j] = "Pata ";
                        break;
                    case 2:
                        cards[i][j] = "Ruutu ";
                        break;
                    case 3:
                        cards[i][j] = "Risti ";
                        break;
                }
                if (i == 10) {
                    cards[i][j] += "J";
                }else if(i == 11) {
                    cards[i][j] += "Q";
                }else if(i == 12) {
                    cards[i][j] += "K";
                }else{
                    cards[i][j] += Integer.toString(i + 1);
                }

                deck[initIndex] = cards[i][j];
                initIndex++;

            }
        }

        deck = shuffle(deck);

        //draw 5 cards for each player
        playerHands = new ArrayList<>();
        for(int i = 0; i < playersCount; i++){
            ArrayList<String> hand = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                hand.add(draw(deck));
            }
            playerHands.add(hand);
        }

        String firstCard = draw(deck);
        middlePile.add(firstCard);
        System.out.println("Card in the middle is: " + middlePile.get(middlePile.size() - 1));


    }

    //play suitable cards from hand if none are suitable draw more cards up to 3 times after which your turn ends

    void makePlay(int player) {

        int drawCounter = 0;
        System.out.println("Player " + (player + 1) + " hand: " + playerHands.get(player));
        boolean didPlayAnything = playBestCardsFromHand(player);

        while (!didPlayAnything && drawCounter < 3){
            System.out.println("Player " + (player + 1) + " doesn't have suitable cards, drawing more...");
            playerHands.get(player).add(draw(deck));
            System.out.println("Player " + (player + 1) + " hand: " + playerHands.get(player));
            didPlayAnything = playBestCardsFromHand(player);
            drawCounter++;
        }
        if(drawCounter >= 3 && !didPlayAnything){
            System.out.println("Player " + (player + 1) + " didn't get any playable cards, hand: " + playerHands.get(player) + "\n");
            System.out.println("Card in the middle is: " + middlePile.get(middlePile.size() - 1) + "\n");
        }

    }


    //game ends when one of the players doesn't have cards anymore
    boolean endOfGame() {
        for(int i = 0; i < playersCount; i++){
            if(playerHands.get(i).size() == 0){
                winner = i + 1;
                return true;
            }
        }

        return false;
    }

    void printWinner() {
        System.out.println("Game over\nWinner is player: " + winner);
    }


    //shuffles a deck of cards
    private String[] shuffle(String[] deck){

        int timesToshuffle = 10;
        String[] shuffled = new String[deck.length];
        for(int i = 0; i < timesToshuffle; i++){
            shuffled = newPositions(deck);
        }
        return shuffled;

    }

    //generates random positions to put the cards in when shuffling
    private String[] newPositions(String[] deck){
        String[] shuffled = new String[deck.length];
        for(int i = 0; i < deck.length; i++){

            int random = (int)(Math.random() * deck.length); //new position
            while (shuffled[random] != null){
                random = (int)(Math.random() * deck.length);
            }
            shuffled[random] = deck[i];

        }
        return shuffled;
    }

    //draws the top card from the deck, if none are left takes the middle pile and shuffles it into new deck
    private String draw(String[] deck){
        String card = deck[cardIndex];
        cardIndex++;
        if(cardIndex > deck.length - 1){
            String[] middle = new String[middlePile.size()];
            middle = middlePile.toArray(middle);
            deck = shuffle(middle);
            System.out.println("Reached last card in deck, shuffling...");
            cardIndex = 0;
        }
        return card;
    }

    //checks if the value of the cards matches
    private boolean checkSameNum(String handCard, String centerCard){
        if(handCard.substring(handCard.length() - 1).equals(centerCard.substring(centerCard.length() - 1))) {
            return true;
        }
        return false;
    }

    //checks if the suit of the cards matches
    private boolean checkSameSuit(String handCard, String centerCard){
        if(handCard.substring(0, handCard.length() - 1).equals(centerCard.substring(0, centerCard.length() - 1))){
            return true;
        }else if(handCard.substring(0, handCard.length() - 2).equals(centerCard.substring(0, centerCard.length() - 1))){
            return true;
        }
        else if(handCard.substring(0, handCard.length() - 1).equals(centerCard.substring(0, centerCard.length() - 2))){
            return true;
        }
        return false;
    }

    //checks if there are any aces in hand that can be played
    private int isAceAndSuit(List<String> hand){
        for (int i = 0; i < hand.size(); i++){
            if(checkSameNum(hand.get(i), "1")){
                if(checkSameSuit(hand.get(i), middlePile.get(middlePile.size() - 1))){
                    return i;
                }

            }
        }
        return -1;
    }


    //checks if tehere are any sevens in hand
    private int isSeven(List<String> hand){
        for (int i = 0; i < hand.size(); i++){
            if(checkSameNum(hand.get(i), "7")){
                return i;
            }
        }
        return -1;
    }

    //gets the playable card and checks if there are any cards with same value in the hand that can be played simultaneously
    private void checkMultiplesAndPlayCards(List<String> hand, String value, int player){
        ArrayList<String> cards = new ArrayList<>();
        for(int i = 0; i < hand.size(); i++){
            if(checkSameNum(hand.get(i), value)){
                cards.add(hand.get(i));
            }
        }

        int size = cards.size();


        //first plays the card that matches the suit of the middle pile card
        for(int i = 0; i < cards.size(); i++){
            playerHands.get(player).remove(cards.get(i));
            if(checkSameSuit(cards.get(i), middlePile.get(middlePile.size() - 1))){
                middlePile.add(cards.get(i));
                System.out.println("Player " + (player + 1) + " played " + cards.get(i));
                cards.remove(i);
            }
        }

        while(!cards.isEmpty()){
            middlePile.add(cards.get(0));
            System.out.println("Player " + (player + 1) + " played " + cards.get(0));
            cards.remove(0);
        }

        if(value.equals("1")){
            for(int i = 0; i < size; i++){
                drawForNextPlayer(player);
            }
        }

        System.out.println("");

    }

    //plays cards from hand in order of importance aces first then sevens then other
    private boolean playBestCardsFromHand(int player){

        List<String> hand = playerHands.get(player);

        if(isAceAndSuit(hand) != -1){
            checkMultiplesAndPlayCards(hand, "1", player);
            System.out.println("Current player gets to continue");
            makePlay(player);
            return true;


        }
        if(isSeven(hand) != -1){
            middlePile.add(hand.get(isSeven(hand)));
            playerHands.get(player).remove(hand.get(isSeven(hand)));
            System.out.println("Player " + (player + 1) + " played " + middlePile.get(middlePile.size() - 1) + "\n");
            System.out.println("Card in the middle is now: " + middlePile.get(middlePile.size() - 1) + "\n");
            if(playerHands.get(player).size() == 0){
                System.out.println("can't end with 7");
                playerHands.get(player).add(draw(deck));
            }
            return true;
        }

        for(int i = 0; i < hand.size(); i++){
            if(checkSameNum(hand.get(i), middlePile.get(middlePile.size() - 1))){
                checkMultiplesAndPlayCards(hand, (hand.get(i).substring(hand.get(i).length() - 1)), player);
                System.out.println("Card in the middle is now: " + middlePile.get(middlePile.size() - 1) + "\n");
                return true;
            }
        }

        for(int i = 0; i < hand.size(); i++){
            if(checkSameSuit(hand.get(i), middlePile.get(middlePile.size() - 1))){
                checkMultiplesAndPlayCards(hand, (hand.get(i).substring(hand.get(i).length() - 1)), player);
                System.out.println("Card in the middle is now: " + middlePile.get(middlePile.size() - 1) + "\n");
                return true;
            }
        }


        return false;
    }

    //makes the next player draw a card
    private void drawForNextPlayer(int player){
        if(player >= playersCount - 1){

            playerHands.get(0).add(draw(deck));
            System.out.println("Player 1 needs to draw a card.");
        }else {
            playerHands.get(player + 1).add(draw(deck));
            System.out.println("Player " + (player + 2) + " needs to draw a card.");
        }
    }

}
