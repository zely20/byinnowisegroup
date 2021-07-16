package by.innowisegroup.action;

import by.innowisegroup.IO.Input;
import by.innowisegroup.model.Role;
import by.innowisegroup.model.User;
import by.innowisegroup.store.Store;

public class EditUserAction implements Action {

    private static final String EMAIL_PATTERN = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    private static final String PHONE_PATTERN = "375\\s\\d{2}\\s\\d{7}";

    @Override
    public String name() {
        return "=== Edit User ===";
    }

    @Override
    public boolean execute(Input input, Store memStore) {
        memStore.findAll().forEach(System.out::println);
        Integer id = input.askInt("select ID of user which you want to edit: ", memStore.findAll().size());
        User user = memStore.findById(id);

        String name = input.askStr("Old name: " + user.getName() + ". If you want to keep the old name, press \"ENTER\"");
        if (isEdit(name)) {
            user.setName(name);
        }

        String surname = input.askStr("Old surname: " + user.getSurname() + ". If you want to keep the old surname, press \"ENTER\"");
        if (isEdit(surname)) {
            user.setSurname(surname);
        }

        String checkEmail = input.askStr("If you want to keep the old email, press \"ENTER\". If you want to change email, press any key");
        if (isEdit(checkEmail)) {
            String email = input.askWithPattern("Old email: " + user.getEmail() + ". Enter email.", EMAIL_PATTERN);
            user.setEmail(email);
        }
        //edit PHONE
        System.out.println("You have the following saved phones: ");
        for (int i = 0; i < user.getPhones().size(); i++) {
            System.out.println(i + 1 + ". " + user.getPhones().get(i));
        }
        System.out.println();

        String checkPhone = input.askStr("If you want to keep the old phone, press \"ENTER\". If you want to change phone, press any key");
        if (isEdit(checkPhone)) {
            int number = input.askInt("Select the number to change.", user.getPhones().size());
            String phone = input.askWithPattern("Enter phone like 375 ** *******: ", PHONE_PATTERN);

            user.getPhones().set(number - 1, phone);
        }
        //add PHONE
        if (user.getPhones().size() < 3) {
            String checkAddPhone = input.askStr("If you want add phone press any key, else press \"ENTER\"");
            if (isEdit(checkAddPhone)) {
                String phone = input.askWithPattern("Enter phone like 375 ** *******: ", PHONE_PATTERN);
                user.getPhones().add(phone);
            }
        }
        System.out.println();
        //change ROLE
        user.getRoles().forEach(System.out::println);
        String checkRole = input.askStr("If you want to keep the old ROLE, press \"ENTER\". If you want to change ROLE, press any key");
        if (isEdit(checkRole)){
            user.getRoles().clear();
            System.out.println("Please choose new ROLE");
            for (int i = 0; i <= 2; i++) {
                System.out.println(i + 1 + ". " + Role.values()[i].name());
            }
            int indexRole = input.askInt("Choose Role First Level or Super_User: ") - 1;
            if(Role.values()[indexRole].equals(Role.SUPER_ADMIN)){
                user.setRole(Role.SUPER_ADMIN);
            } else {
                user.setRole(Role.values()[indexRole]);
                for (int i = 3; i < 5; i++) {
                    System.out.println(i - 2 + ". " + Role.values()[i].name());
                }
                int indexRoleTwo = input.askInt("Choose Role Second Level: ") + 2;
                user.setRole(Role.values()[indexRoleTwo]);
            }
        }
        System.out.println();
        System.out.println(user);
        memStore.replace(user);
        return true;
    }

    private boolean isEdit(String conditions) {
        return !conditions.equals("");
    }
}
