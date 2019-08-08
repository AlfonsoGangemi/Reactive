package it.gangemi.reactive.rxjava;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListEmitter {

    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        final Stream<Character> a = Stream.of('A', 'B', 'C', 'D', 'E');
        final Observable<Character> characterObservable = Observable
                .fromIterable(a.collect(Collectors.toList()));

        characterObservable
                .filter(ListEmitter::isVowel)
                .subscribe(x->System.out.println("VOWEL:"+x), Throwable::printStackTrace);
        characterObservable
                .subscribe(x->System.out.println("ALL:"+x), Throwable::printStackTrace);
    }

    private static boolean isVowel(Character s) {
        return VOWELS.contains(s);
    }

}
