package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8, V_9, V_10, Jack, Queen, King, Ace
    }

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
        Suit[] suits = Suit.values();
        Value[] val = Value.values();
        Stream.of(suits)
                .flatMap(s -> Stream.of(val)
                .map(v -> new Card(s, v)))
                .forEach(System.out::println);
    }
}
