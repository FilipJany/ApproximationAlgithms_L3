package logic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Derandomized solver for MAX-SAT
 *
 * Created by Patryk Stopyra on 06.06.2016.
 */
public class DerandomizedSolver {

    public Formula formula;

    public DerandomizedSolver(Formula formula)
    {
        this.formula = formula;
    }

    public double expected(List<Clause> clauses, int[] expectation) {
        double sum = 0.0;
        int i = 0;

        for (Clause c : clauses) {
            expectation[i] = c.getVariables().size();
            sum += (1 - 1/Math.pow(2, expectation[i])) * c.getWeight();
            i++;
        }

        return sum;
    }

    public double expectedIf(List<Clause> clauses, int[] unrestrictedNo, boolean[] fulfilled, Variable var, boolean val) {
        double sum = 0.0;
        int i = 0;

        for (Clause c : clauses) {
            if (fulfilled[i]) {
                sum += c.getWeight();
            } else if (unrestrictedNo[i] != 0) { // i fulfilled is false & unrestricted is non-zero: expected = 0
                if (c.getVariables().contains(var)) {
                    Variable clauseVar = c.getVariables().get(
                            c.getVariables().indexOf(var));
                    if ((clauseVar.isNegated() && val == false) || (!clauseVar.isNegated() && val == true)) {
                        sum += c.getWeight();
                    } else {
                        if (unrestrictedNo[i] > 1)
                            sum += (1 - 1 / Math.pow(2, unrestrictedNo[i]-1)) * c.getWeight();
                    }
                } else {
                    sum += (1 - 1 / Math.pow(2, unrestrictedNo[i])) * c.getWeight();
                }
            }
            i++;
        }

        return sum;
    }

    public void expectedUpdate(List<Clause> clauses, int[] unrestrictedNo, boolean[] fulfilled, Variable var, boolean val) {
        int i = 0;

        for (Clause c : clauses) {
            if (!fulfilled[i] && unrestrictedNo[i] != 0) { // i fulfilled is false & unrestricted is non-zero: expected = 0
                if (c.getVariables().contains(var)) {
                    Variable clauseVar = c.getVariables().get(
                            c.getVariables().indexOf(var));
                    if ((clauseVar.isNegated() && val == false) || (!clauseVar.isNegated() && val == true)) {
                        fulfilled[i] = true;
                    }
                    unrestrictedNo[i]--;
                }
            }
            i++;
        }
    }

    public int numberFulfilledByVar(List<Clause> clauses, int[] unrestrictedNo, boolean[] fulfilled, Variable var, boolean val) {
        int sum = 0;
        int i = 0;

        for (Clause c : clauses) {
            if (!fulfilled[i] && unrestrictedNo[i] != 0) { // i fulfilled is false & unrestricted is non-zero: expected = 0
                if (c.getVariables().contains(var)) {
                    Variable clauseVar = c.getVariables().get(
                            c.getVariables().indexOf(var));
                    if ((clauseVar.isNegated() && val == false) || (!clauseVar.isNegated() && val == true)) {
                        sum += c.getWeight();
                    }
                }
            }
            i++;
        }

        return sum;
    }

    public int calculate() {
        int[] unrestrictedNo = new int[formula.getClauses().size()]; //contains number of still abstract variables per clause
        boolean[] fulfilled = new boolean[formula.getClauses().size()];

        expected(formula.getClauses(), unrestrictedNo);
        for (Variable v : formula.getVariables()) {
            double expectedTrue = expectedIf(formula.getClauses(), unrestrictedNo, fulfilled, v, true)
                    + numberFulfilledByVar(formula.getClauses(), unrestrictedNo, fulfilled, v, true);
            double expectedFalse = expectedIf(formula.getClauses(), unrestrictedNo, fulfilled, v, true)
                    + numberFulfilledByVar(formula.getClauses(), unrestrictedNo, fulfilled, v, false);

            if (expectedTrue > expectedFalse) {
                v.setValue(true);
                expectedUpdate(formula.getClauses(), unrestrictedNo, fulfilled, v, true);
            } else {
                v.setValue(false);
                expectedUpdate(formula.getClauses(), unrestrictedNo, fulfilled, v, false);
            }
        }

        int sum = 0;
        int i = 0;
        for (Clause c : formula.getClauses()) {
            if (fulfilled[i])
                sum += c.getWeight();
            i++;
        }


        return sum;
    }

    public void solve() {
        System.out.println(formula.toString());
        for (Variable v : formula.getVariables())
            System.out.println(v.toString() + ": " + v.getValue());
        System.out.println("Total value: " + calculate());
    }
}
