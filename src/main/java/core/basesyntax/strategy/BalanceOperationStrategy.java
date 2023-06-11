package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationStrategy implements OperationStrategy {
    @Override
    public void operationStrategy(FruitTransaction transaction, FruitStorage fruitStorage) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (fruitStorage.getFruit(fruitName) == null) {
            FruitTransaction newBalance = new FruitTransaction(FruitTransaction
                    .Operation.BALANCE, fruitName, quantity);
            fruitStorage.addFruit(new Fruit(fruitName, quantity));
        } else {
            Fruit fruit = fruitStorage.getFruit(fruitName);
            fruit.setQuantity(quantity);
        }
    }
}
