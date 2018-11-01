package com.learzhu.browser.test.optimal_solution_of_algorithm.unit1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PetEnterQueue.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-11-01 17:11
 * @update Learzhu 2018-11-01 17:11
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public DogCatQueue() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("Dog")) {
            this.dogQueue.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getType().equals("Cat")) {
            this.catQueue.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err,not dog or cat");
        }
    }

    /**
     * 按照先后将所有的宠物弹出
     *
     * @return
     */
    public Pet pollAll() {
        //猫狗俩队列都有内容
        if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
            if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
                return this.dogQueue.poll().getPet();
            } else {
                return this.catQueue.poll().getPet();
            }
        } else if (!this.dogQueue.isEmpty()) {
            return this.dogQueue.poll().getPet();
        } else if (!this.catQueue.isEmpty()) {
            return this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Dog pollDog() {
        if (!this.isDogQueueEmpty()) {
            return (Dog) this.dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    public boolean isEmpty() {
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQueue.isEmpty();
    }

    public static void main(String args[]) {

    }
}

class Dog extends Pet {
    public Dog() {
        super("Dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("Cat");
    }
}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

/**
 * 排队的对象包装有宠物对象和时间
 */
class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return this.pet.getType();
    }
}
