package App;

import java.util.Random;

public class IDGenerator {

        private static IDGenerator idGenerator;

        private String currentID = "";
        private int counter = 0;
        private int generatingLength = 8;

        private IDGenerator(){}

        public static IDGenerator getInstance() {
            if (idGenerator == null) {
                idGenerator = new IDGenerator();
            }
            return idGenerator;
        }

        public void generateID() {
            // characters and numbers that will fill the remaining slots
            String generateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String generateNums = "0123456789";
            // increment counter like in other Singleton counters
            counter++;
            // turn counter into string and use it as the first set of numbers
            String counterStr = String.valueOf(counter);
             currentID= counterStr;
            // concatenate the remaining of the given slots(8) with random characters
            for(int index = 0; index < (generatingLength-counterStr.length()); index++){
                Random random = new Random();
                // is used to make sure that the first random is a letter for uniqueness reasons
                if(index == 0){
                    int randIdx = random.nextInt(generateChars.length());
                    currentID = generateChars.charAt(randIdx) + currentID;
                } else {
                    int randIdx = random.nextInt((generateChars+generateNums).length());
                    currentID = (generateChars+generateNums).charAt(randIdx) + currentID;
                }
            }


        }

        public String getID() {
            return this.currentID;
        }

    }


