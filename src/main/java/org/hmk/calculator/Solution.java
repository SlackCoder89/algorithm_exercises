package org.hmk.calculator;

import java.util.List;

public class Solution {
    double compute(String  sequence) {
        List<Term> terms = Term.parseTermSequence(sequence);
        if (terms == null) {
            return Integer.MIN_VALUE;
        }

        double result = 0;
        Term processing = null;
        for (int i = 0; i < terms.size(); ++i) {
            Term current = terms.get(i);
            Term next = i + 1 < terms.size() ? terms.get(i + 1) : null;
            
            processing = collapseTerm(processing, current);
            if (next == null || next.getOperator() == Term.Operator.ADD
            || next.getOperator() == Term.Operator.SUBTRACT) {
                result = applyOp(result, processing.getOperator(), processing.getNumber());
                processing = null;
            }
        }
        return result;
    }

    private Term collapseTerm(Term primary, Term secondary) {
        if (primary == null) {
            return secondary;
        }
        if (secondary == null) {
            return primary;
        }
        double value = applyOp(primary.getNumber(), secondary.getOperator(), secondary.getNumber());
        primary.setNumber(value);
        return primary;
    }

    private double applyOp(double number, Term.Operator operator, double number1) {
        return 0;
    }
}

class Term {
    enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK
    }
    double value;
    Operator operator = Operator.BLANK;

    Term(double v, Operator op) {
        value = v;
        operator = op;
    }

    double getNumber() {
        return value;
    }

    Operator getOperator() {
        return operator;
    }

    void setNumber(double v) {
        value = v;
    }

    static List<Term> parseTermSequence(String s) {
        return null;
    }
}
