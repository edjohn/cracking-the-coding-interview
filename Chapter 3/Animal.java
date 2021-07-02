public abstract class Animal 
{
    protected int order;
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }
    public boolean isOlderThan(Animal animal) { return this.getOrder() < animal.getOrder(); }
}

class Dog extends Animal
{
}

class Cat extends Animal
{
}