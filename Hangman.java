import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Hangman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Func obj = new Func();
        WordBank bank = new WordBank();

        String str = "", theme = "", tmp, gameMode = "";
        String[] word = null, wordhide = null;
        int mistake, score1 = 0, score2 = 0, tmp2;
        ArrayList<String> guess = new ArrayList<>();

        System.out.println("Welcome to Hangman - By Aryan Tiwari");
        obj.sleep(1.5);
        obj.cls();
        obj.cls();
        boolean game = true;
        int iter = 1;

        System.out.println("Enter your choice:");
        System.out.println("1: Multiplayer\n2: Singleplayer\nEnter:");
        int choice = sc.nextInt();
        sc.nextLine();
        int win = 0;
        obj.cls();
        if (choice == 1) {
            System.out.println("Please decide who is player 1 and 2.\nYou have 5 seconds to decide.");
            obj.sleep(5.0);
            obj.sleep(2.5);
            obj.cls();
        }
        switch (choice) {// switch starts
            case 1:
                while (game == true) {// while starts
                    if (iter % 2 != 0) {
                        System.out.println("Player 2, Please look away from the screen.");
                        win = 0;
                        System.out.print("Player 1, Enter a word/words:");
                        str = sc.nextLine().toLowerCase();
                        word = obj.split(str);
                        wordhide = Arrays.copyOf(word, word.length);
                        System.out.println("Enter the theme of the word/words:");
                        theme = sc.nextLine();
                        obj.sleep(1.0);
                        obj.cls();
                        System.out.println("Player 2, Please look at the screen.");
                        obj.sleep(2.5);
                        obj.cls();
                        guess.clear();

                        mistake = 0;
                        while (win == 0) {
                            obj.cls();
                            System.out.println("Mistakes: " + mistake + "/5");
                            System.out.println("Theme: " + theme);
                            System.out.print("Word: ");
                            obj.show(wordhide, word);
                            System.out.print(" (" + str.length() + ")");
                            System.out.println();
                            System.out.print("Player 2, Enter a character:");
                            String ch = Character.toString(sc.next().charAt(0)).toLowerCase();
                            if (obj.repeat(guess, ch) == true) {
                                System.out.println("Repeated Guess!");
                            } else {
                                guess.add(ch);
                            }
                            word = obj.check(word, ch);
                            if (obj.win(word) == true) {

                                System.out.println("Winner is Player 2. You correctly guessed.");
                                obj.sleep(2.0);
                                score2++;
                                win = 1;
                            } else {
                                if (mistake > 4) {
                                    System.out.println("Winner is Player 1. The word was " + str + ".");
                                    score1++;
                                    win = 1;
                                } else if (obj.verify(wordhide, ch) == false) {
                                    System.out.println("Wrong Guess!");
                                    mistake++;
                                    System.out.println("Mistakes: " + mistake + "/5");
                                }
                            }
                        }
                        while (true) {
                            System.out.print("Would you like another round?Y/N:");
                            tmp = Character.toString(sc.next().charAt(0)).toUpperCase();
                            if (tmp.equals("Y") || tmp.equals("N")) {
                                break;
                            } else {
                                System.out.println("Error. Please enter Y/N.");
                            }
                        }
                        if (tmp.equals("N")) {
                            System.out.println("Thank you for playing!");
                            System.out.println("Scores:");
                            System.out.println("Player 1: " + score1);
                            System.out.println("Player 2: " + score2);
                            System.exit(0);
                        }
                        iter++;
                        sc.nextLine();
                        word = null;
                        wordhide = null;
                        mistake = 0;
                        obj.cls();
                    } else {
                        System.out.println("Player 1, Please look away from the screen.");
                        win = 0;
                        System.out.print("Player 2, Enter a word/words:");
                        str = sc.nextLine().toLowerCase();
                        word = obj.split(str);
                        wordhide = Arrays.copyOf(word, word.length);
                        System.out.println("Enter the theme of the word/words:");
                        theme = sc.nextLine();
                        obj.cls();
                        System.out.println("Player 1, Please look at the screen.");
                        obj.sleep(2.5);
                        obj.cls();
                        guess.clear();

                        mistake = 0;
                        while (win == 0) {
                            obj.cls();
                            System.out.println("Mistakes: " + mistake + "/5");
                            System.out.println("Theme: " + theme);
                            System.out.print("Word: ");
                            obj.show(wordhide, word);
                            System.out.print(" (" + str.length() + ")");
                            System.out.println();
                            System.out.print("Player 1, Enter a character:");
                            String ch = Character.toString(sc.next().charAt(0)).toLowerCase();
                            if (obj.repeat(guess, ch) == true) {
                                System.out.println("Repeated Guess!");
                            } else {
                                guess.add(ch);
                            }
                            word = obj.check(word, ch);
                            if (obj.win(word) == true) {

                                System.out.println("Winner is Player 1. You correctly guessed.");
                                obj.sleep(2.0);
                                score1++;
                                win = 1;
                            } else {
                                if (mistake > 4) {
                                    System.out.println("Winner is Player 2. The word was " + str + ".");
                                    score2++;
                                    win = 1;
                                } else if (obj.verify(wordhide, ch) == false) {
                                    System.out.println("Wrong Guess!");
                                    mistake++;
                                    System.out.println("Mistakes: " + mistake + "/5");
                                }
                            }
                        }
                        while (true) {
                            System.out.print("Would you like another round?Y/N:");
                            tmp = Character.toString(sc.next().charAt(0)).toUpperCase();
                            if (tmp.equals("Y") || tmp.equals("N")) {
                                break;
                            } else {
                                System.out.println("Error. Please enter Y/N.");
                            }
                        }
                        if (tmp.equals("N")) {
                            System.out.println("Thank you for playing!");
                            System.out.println("Scores:");
                            System.out.println("Player 1: " + score1);
                            System.out.println("Player 2: " + score2);
                            System.exit(0);
                        }
                        iter++;
                        sc.nextLine();
                        word = null;
                        wordhide = null;
                        mistake = 0;
                        obj.cls();
                    }
                } // while ends
                break;
            case 2:
                System.out.println("You will be player 1. The computer will be player 2.");
                obj.sleep(2.0);
                obj.cls();
                System.out.println("Chose:");
                System.out.println("1: Be the guesser first.");
                System.out.println("2: Computer is guesser.");
                while (true) {
                    if (sc.hasNextInt()) {
                        tmp2 = Integer.parseInt(Character.toString(sc.next().charAt(0)));
                        break;
                    } else {
                        sc.next();
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }
                sc.nextLine();
                iter = (tmp2 == 1) ? 1 : 0;
                while (game == true) {// while starts
                    if (iter % 2 == 0) {
                        win = 0;
                        System.out.print("Player 1, Enter a word/words:");
                        str = sc.nextLine().toLowerCase();
                        word = obj.split(str);
                        wordhide = Arrays.copyOf(word, word.length);
                        System.out.println("Enter the theme of the word/words:");
                        theme = sc.nextLine();
                        obj.sleep(1.0);
                        obj.cls();
                        System.out.println("The computer will now try to guess.");
                        obj.sleep(2.5);
                        obj.cls();
                        guess.clear();

                        mistake = 0;
                        while (win == 0) {
                            obj.cls();
                            System.out.println("Mistakes: " + mistake + "/5");
                            System.out.println("Theme: " + theme);
                            System.out.print("Word: ");
                            obj.show(wordhide, word);
                            System.out.print(" (" + str.length() + ")");
                            System.out.println();
                            String tmp4 = obj.guess(wordhide, 0.9);
                            System.out.print("Player 2, Enter a character: " + tmp4);
                            String ch = tmp4;
                            if (obj.repeat(guess, ch) == true) {
                                System.out.println();
                                System.out.println("Repeated Guess!");
                            } else {
                                guess.add(ch);
                            }
                            word = obj.check(word, ch);
                            if (obj.win(word) == true) {
                                System.out.println();
                                System.out.println("Winner is Player 2. The computer guessed correctly.");
                                obj.sleep(2.0);
                                score2++;
                                win = 1;
                            } else {
                                if (mistake > 4) {
                                    System.out.println();
                                    System.out.println("Winner is Player 1. The word was " + str + ".");
                                    score1++;
                                    win = 1;
                                } else if (obj.verify(wordhide, ch) == false) {
                                    // System.out.println("Wrong Guess!");
                                    mistake++;
                                    // System.out.println("Mistakes: " + mistake + "/5");
                                }
                            }
                            obj.sleep(2.0);
                        }
                        while (true) {
                            System.out.print("Would you like another round?Y/N:");
                            tmp = Character.toString(sc.next().charAt(0)).toUpperCase();
                            if (tmp.equals("Y") || tmp.equals("N")) {
                                break;
                            } else {
                                System.out.println("Error. Please enter Y/N.");
                            }
                        }
                        if (tmp.equals("N")) {
                            System.out.println("Thank you for playing!");
                            System.out.println("Scores:");
                            System.out.println("Player 1: " + score1);
                            System.out.println("Player 2: " + score2);
                            System.exit(0);
                        }
                        iter++;
                        sc.nextLine();
                        word = null;
                        wordhide = null;
                        mistake = 0;
                        obj.cls();
                        obj.sleep(0.1);
                    } else {
                        gameMode = "";
                        int x = '\0';
                        while (!gameMode.equals("easy") && !gameMode.equals("medium") && !gameMode.equals("hard")) {
                            System.out.println("Choose a game mode: easy, medium, or hard");
                            gameMode = sc.nextLine().toLowerCase();
                            switch (gameMode) {
                                case "easy":
                                    System.out.println("You selected easy mode.");
                                    x = 1;
                                    break;
                                case "medium":
                                    System.out.println("You selected medium mode.");
                                    x = 2;
                                    break;
                                case "hard":
                                    System.out.println("You selected hard mode.");
                                    x = 3;
                                    break;
                                default:
                                    System.out.println("Invalid input. Please choose a valid game mode.");
                            }
                        }
                        System.out.println("Player 1, Please wait till computer picks a word.");
                        win = 0;
                        if (x == 1) {
                            int tmp3 = (int) (Math.random() * bank.easyWords.length - 1) + 0;
                            str = bank.easyWords[tmp3];
                            word = obj.split(str);
                            wordhide = Arrays.copyOf(word, word.length);
                            theme = bank.easyThemes[tmp3];
                        } else if (x == 2) {
                            int tmp3 = (int) (Math.random() * bank.mediumWords.length - 1) + 0;
                            str = bank.mediumWords[tmp3];
                            word = obj.split(str);
                            wordhide = Arrays.copyOf(word, word.length);
                            theme = bank.mediumThemes[tmp3];
                        } else if (x == 3) {
                            int tmp3 = (int) (Math.random() * bank.hardWords.length - 1) + 0;
                            str = bank.hardWords[tmp3];
                            word = obj.split(str);
                            wordhide = Arrays.copyOf(word, word.length);
                            theme = bank.hardThemes[tmp3];
                        }
                        obj.sleep(2.0);
                        obj.cls();
                        guess.clear();

                        mistake = 0;
                        while (win == 0) {
                            obj.cls();
                            System.out.println("Mistakes: " + mistake + "/5");
                            System.out.println("Theme: " + theme);
                            System.out.print("Word: ");
                            obj.show(wordhide, word);
                            System.out.print(" (" + str.length() + ")");
                            System.out.println();
                            System.out.print("Player 1, Enter a character:");
                            String ch = Character.toString(sc.next().charAt(0)).toLowerCase();
                            if (obj.repeat(guess, ch) == true) {
                                System.out.println("Repeated Guess!");
                            } else {
                                guess.add(ch);
                            }
                            word = obj.check(word, ch);
                            if (obj.win(word) == true) {

                                System.out.println("Winner is Player 1. You correctly guessed.");
                                obj.sleep(2.0);
                                score1++;
                                win = 1;
                            } else {
                                if (mistake > 4) {
                                    System.out.println("The computer wins. The word was " + str + ".");
                                    score2++;
                                    win = 1;
                                } else if (obj.verify(wordhide, ch) == false) {
                                    System.out.println("Wrong Guess!");
                                    mistake++;
                                    System.out.println("Mistakes: " + mistake + "/5");
                                }
                            }
                        }
                        while (true) {
                            System.out.print("Would you like another round?Y/N:");
                            tmp = Character.toString(sc.next().charAt(0)).toUpperCase();
                            if (tmp.equals("Y") || tmp.equals("N")) {
                                break;
                            } else {
                                System.out.println("Error. Please enter Y/N.");
                            }
                        }
                        if (tmp.equals("N")) {
                            System.out.println("Thank you for playing!");
                            System.out.println("Scores:");
                            System.out.println("Player 1: " + score1);
                            System.out.println("Computer: " + score2);
                            System.exit(0);
                        }
                        iter++;
                        sc.nextLine();
                        word = null;
                        wordhide = null;
                        mistake = 0;
                        obj.cls();
                    }
                } // while ends
        }// switch ends
        sc.close();
    }
}

class Func {
    static int c;
    static WordBank obj2 = new WordBank();

    public String[] split(String a) {
        String[] b;
        c = a.length();
        b = new String[c + 1];
        b[0] = "";
        for (int i = 0; i <= a.length() - 1; i++) {
            b[i + 1] = String.valueOf(a.charAt(i));
        }
        return b;
    }

    public void print(String[] b) {
        for (int i = 1; i <= c; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }

    public String[] check(String[] a, String ch) {
        for (int i = 1; i <= c; i++) {
            boolean tmp1 = (int) (a[i].charAt(0)) == (int) (ch.charAt(0));
            if (tmp1 == true) {
                a[i] = "*";
            }
        }
        return a;
    }

    public void cls() {
        System.out.print("\u000C"); // only BlueJ
        System.out.flush();
    }

    public void sleep(double a) {
        int b = (int) (a * 1000);
        try {
            Thread.sleep(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean win(String[] a) {
        int b = 0;
        boolean flag = false;
        for (int i = 1; i <= c; i++) {
            if (a[i].equals("*"))
                b++;
        }
        if (b == c)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void show(String[] a, String[] b) {
        for (int i = 1; i <= c; i++) {
            if (a[i].equals(b[i])) {
                if (!a[i].equals(" "))
                    System.out.print("_ ");
                else {
                    System.out.print(" ");
                }
            } else {
                System.out.print(a[i] + " ");
            }
        }
    }

    public boolean repeat(ArrayList<String> a, String g) {
        if (a.contains(g) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verify(String[] a, String b) {
        for (int i = 1; i <= a.length-1; i++) {

            if (a[i].equals(b)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("static-access")
    public String guess(String[] a, double chance) {
        double rand = Math.random();
        if (rand < chance) {
            return obj2.set[(int)(Math.random() * obj2.set.length-1)];
        } else {
            return obj2.set[(int)(Math.random() * obj2.set.length-1)];
        }
    }
}

class WordBank {
    // Easy Words
    public String[] easyWords = {
            "apple", "banana", "car", "dog", "house",
            "sun", "moon", "book", "pen", "tree",
            "ball", "bird", "cat", "fish", "flower",
            "hat", "key", "milk", "nest", "ocean",
            "pear", "queen", "ring", "shoe", "table",
            "cake", "clock", "duck", "egg", "frog",
            "goat", "honey", "ice", "jacket", "kite",
            "lamp", "map", "nest", "orange", "puzzle",
            "quilt", "robot", "sock", "train", "umbrella",
            "volcano", "water", "xylophone", "yacht", "zebra"
    };

    // Tricky Words
    public String[] hardWords = {
            "ambiguous", "puzzle", "rhythm", "awkward", "cryptic",
            "czar", "exquisite", "fuchsia", "mnemonic", "psyche",
            "haphazard", "labyrinth", "onomatopoeia", "serendipity", "tintinnabulation",
            "vituperative", "whimsical", "xenophobia", "cacophony", "prestidigitation",
            "sesquipedalian", "effervescent", "ubiquitous", "brouhaha", "gobbledygook",
            "mellifluous", "perspicacious", "quixotic", "syzygy", "xylograph",
            "quagmire", "triskaidekaphobia", "weltschmerz", "zephyr", "pulchritudinous"
    };

    // Moderate Words
    public String[] mediumWords = {
            "computer", "guitar", "rainbow", "library", "oxygen",
            "sunflower", "television", "mountain", "elephant", "astronomy",
            "chemistry", "dictionary", "giraffe", "helicopter", "jupiter",
            "knowledge", "elephant", "universe", "zookeeper", "submarine",
            "adventure", "captain", "fantasy", "exploration", "discovery",
            "galaxy", "invention", "meteorite", "nebula", "observation",
            "planetarium", "satellite", "telescope", "whale", "constellation",
            "stargazing", "penguin", "iceberg", "antarctica", "explorer",
            "researcher", "environment", "volcano", "geography", "scientist",
            "paleontology", "evolution", "biology", "chemistry", "experiment",
            "hypothesis", "discovery", "investigation", "molecule", "particle",
            "genetics", "ecosystem", "ecology", "organism", "photosynthesis",
            "respiration", "mitosis", "fossil", "skeleton", "adaptation",
            "evolution", "migration", "mutation", "species", "diversity",
            "ecological", "interaction", "extinction", "habitat", "population"
    };

    // Themes for Easy Words
    public String[] easyThemes = {
            "Colors", "Transportation", "Animals", "Home", "Nature",
            "Sky", "Books", "Writing", "Plants", "Toys",
            "Pets", "Aquatic Life", "Animal", "Food", "Flowers",
            "Accessories", "Keys", "Drinks", "Nests", "Bodies of Water",
            "Fruits", "Royalty", "Jewelry", "Footwear", "Furniture",
            "Desserts", "Timepieces", "Waterfowl", "Food", "Amphibians",
            "Farm Animals", "Sweeteners", "Frozen Treats", "Clothing", "Games",
            "Bedding", "Robots", "Clothing", "Transportation", "Weather",
            "Bodies of Water", "Musical Instruments", "Boating", "Stripes", "Alphabets"
    };

    // Themes for Tricky Words
    public String[] hardThemes = {
            "Abstract Concepts", "Puzzles", "Rhythms", "Challenges", "Mystery",
            "Authority", "Aesthetics", "Colors", "Memory", "Mind",
            "Randomness", "Maze", "Language", "Discovery", "Bell Ringing",
            "Criticism", "Fantasy", "Fear", "Loud Sounds", "Magic",
            "Long Words", "Bubbling", "Everywhere", "Commotion", "Nonsense Language",
            "Melodic Sounds", "Insight", "Impractical", "Planetary Alignment", "Woodworking",
            "Difficult Situation", "Fear of Numbers", "Emotional Pain", "Breeze", "Physical Beauty"
    };

    // Themes for Moderate Words
    public String[] mediumThemes = {
            "Technology", "Music", "Nature Wonders", "Reading Place", "Chemistry",
            "Plants", "Entertainment", "Geography", "Animals", "Space",
            "Science", "Literature", "Animals", "Air Travel", "Space Exploration",
            "Knowledge", "Animals", "Space", "Zoo", "Oceanography",
            "Adventure", "Leadership", "Imagination", "Exploration", "Discovery",
            "Astronomy", "Innovation", "Space Rocks", "Astronomy", "Research",
            "Space Museums", "Inventions", "Observation", "Marine Life", "Astronomy",
            "Stargazing", "Birds", "Frozen Places", "Polar Regions", "Exploration",
            "Research", "Environment", "Volcanoes", "Geography", "Science",
            "Prehistoric Life", "Genetics", "Biology", "Chemistry", "Experiments",
            "Theories", "Discoveries", "Investigations", "Molecules", "Cells",
            "Genetics", "Ecosystems", "Ecology", "Biology", "Botany",
            "Breathing", "Cell Division", "Fossils", "Anatomy", "Adaptations",
            "Evolution", "Migration", "Mutations", "Species", "Diversity",
            "Interactions", "Extinction", "Habitats", "Populations"
    };
    static public String[] set = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    };
}
