package by.bntu.fitr.povt.javanutie.utilits;

import by.bntu.fitr.povt.javanutie.model.container.Basket;
import by.bntu.fitr.povt.javanutie.model.container.Container;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Phone;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;

import java.io.*;
import java.time.LocalDate;

public class BinaryReaderWriterGameRoom implements Reader {
    public void write(String filename, Container<Gadget> container) {
        try(DataOutputStream file = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)))) {
            boolean correctly;
            for (Gadget gadget : container) {
                String gadgetType = gadget.getClass().getSimpleName();
                file.writeUTF(gadgetType);
                correctly = true;

                if (gadgetType.equals(Powerbank.class.getSimpleName())) {
                    file.writeUTF(((Powerbank) gadget).getColor().name());
                    file.writeInt(((Powerbank) gadget).getCapacity());
                } else if (gadgetType.equals(Phone.class.getSimpleName())) {
                    file.writeDouble(((Phone) gadget).getDiagonal());
                    file.writeUTF(((Phone) gadget).getCpu());
                } else {
                    correctly = false;
                }

                if (correctly) {
                    file.writeDouble(gadget.getPrice());
                    file.writeDouble(gadget.getPrestige());
                }
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    public void read(String filename, Container<Gadget> container) {
        try(DataInputStream file = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {
            while (file.available() != 0) {
                String gadgetType = file.readUTF();
                Gadget gadget = null;
                if (gadgetType.equals(Powerbank.class.getSimpleName())) {
                    gadget = new Powerbank();
                    String color = file.readUTF();
                    ((Powerbank) gadget).setColor(Powerbank.Color.valueOf(color));
                    ((Powerbank) gadget).setCapacity(file.readInt());
                } else if (gadgetType.equals(Phone.class.getSimpleName())) {
                    gadget = new Phone();
                    ((Phone) gadget).setDiagonal(file.readDouble());
                    ((Phone) gadget).setCpu(file.readUTF());
                }
                if (gadget != null) {
                    gadget.setPrice(file.readDouble());
                    gadget.setPrestige(file.readDouble());

                    container.add(gadget);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception);
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}
