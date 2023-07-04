package algorithums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {

    public static void main(String[] args) {


        // 50% winner only


        // list votes

        // ako e 50%  return -1

        // ako nqkoi nad 50 % - return index of president


        List<Integer> votes = Arrays.asList(1, 1, 1, 3, 3, 3, 5, 5, 5, 5, 5, 5);


        Integer winnerIndex = getWinnerPresident(votes);

        System.out.println(winnerIndex);
        //winner = lenght / 2 + 1 ;

    }


//    List<Integer> votes = Arrays.asList(1, 1, 1, 3, 3, 3, 5, 5, 5, 5, 5, 5);
    public static int getWinnerPresident(List<Integer> votes) {


        int winnerMinVotes = (votes.size() / 2)  + 1; // 1`


        //winnerIndex = 1
        //maxCount = 3;
        // unique vote = 3

        for (Intege r vote : votes) {

            if (predidentVoteMap.containsKey(vote)) { // if this key is bigger then winnerMinVotes
                //increment
                predidentVoteMap.put(vote, predidentVoteMap.get(vote) + 1);
            } else {b
                predidentVoteMap.put(vote, 1);
            }

        }
  // -1


        int winnerMinVotes = (votes.size() / 2)  + 1;



        Integer winnerIndex = -1;

        for(Integer presidentKey : predidentVoteMap.keySet()){

            final Integer numberOfVotes = predidentVoteMap.get(presidentKey);


            if(numberOfVotes >= winnerMinVotes ){
                return presidentKey;
            }

        }

        return winnerIndex;
    }
}
