package Visitor;

import Models.Auto;
import Models.Motorcycle;

public interface Visitor {
    void visit(Auto auto);

    void visit(Motorcycle moto);
}
