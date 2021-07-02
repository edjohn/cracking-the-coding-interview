import java.util.LinkedList;

class AnimalShelter
{
    private LinkedList<Dog> dogs = new LinkedList<Dog>();
    private LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal animal)
    {
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog)
        {
            dogs.addLast((Dog)animal);
        }
        if (animal instanceof Cat)
        {
            cats.addLast((Cat)animal);
        }
    }

    public Animal dequeue()
    {
        if (dogs.isEmpty())
        {
            return dequeueCat();
        }
        if (cats.isEmpty())
        {
            return dequeueDog();
        }

        Dog oldestDog = dogs.peek();
        Cat oldestCat = cats.peek();
        if (oldestDog.isOlderThan(oldestCat))
        {
            return dequeueDog();
        }
        else
        {
            return dequeueCat();
        }
    }

    public Dog dequeueDog()
    {
        return dogs.poll();
    }

    public Cat dequeueCat()
    {
        return cats.poll();
    }

    public void printAnimals()
    {
        while (!dogs.isEmpty() || !cats.isEmpty())
        {
            Animal animal = dequeue();
            System.out.printf("%s %d -> ", animal.getClass(), animal.getOrder());
        }
    }
}