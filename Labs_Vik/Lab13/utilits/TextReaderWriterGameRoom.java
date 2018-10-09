package by.bntu.fitr.povt.javanutie.utilits;

import by.bntu.fitr.povt.javanutie.model.container.Container;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Phone;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;

import java.io.*;

public class TextReaderWriterGameRoom implements Reader {

    public void write(String filename, Container<Gadget> container) {
        final String r = "\n";

        try(BufferedWriter file = new BufferedWriter(
                new FileWriter(filename))) {
            boolean correctly;
            for(Gadget gadget : container) {
                String gadgetType = gadget.getClass().getSimpleName();
                file.write(gadgetType + r);
                correctly = true;

                if(gadgetType.equals(Powerbank.class.getSimpleName())) {
                    file.write(((Powerbank) gadget).getColor().name() + r);
                    file.write(((Powerbank) gadget).getCapacity() + r);
                } else if (gadgetType.equals(Phone.class.getSimpleName())) {
                    file.write(((Phone) gadget).getDiagonal() + r);
                    file.write(((Phone) gadget).getCpu() + r);
                } else {
                    correctly = false;
                }

                if (correctly) {
                    file.write(gadget.getPrice() + r);
                    file.write(gadget.getPrestige() + r);
                }
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    public void read(String filename, Container<Gadget> container) {
        try(BufferedReader file = new BufferedReader(
                new FileReader(filename))) {

            String gadgetType;
            while ((gadgetType = file.readLine()) != null) {
                Gadget gadget = null;

                if (gadgetType.equals(Powerbank.class.getSimpleName())) {
                    gadget = new Powerbank();
                    String color = file.readLine();
                    ((Powerbank) gadget).setColor(Powerbank.Color.valueOf(color));
                    ((Powerbank) gadget).setCapacity(new Integer(file.readLine()));
                } else if (gadgetType.equals(Phone.class.getSimpleName())) {
                    gadget = new Phone();
                    ((Phone) gadget).setDiagonal(new Double(file.readLine()));
                    ((Phone) gadget).setCpu(file.readLine());
                }
                if (gadget != null) {
                    gadget.setPrice(new Double(file.readLine()));
                    gadget.setPrestige(new Double(file.readLine()));

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
