package com.bl.addressbook.service;

import com.addressbok.model.Person;
import com.bl.addressbook.service.IAddressBookService;

package com.bl.addressbook.service;

import com.addressbok.model.Person;
import com.bl.addressbook.service.IAddressBookService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class AddressBookService implements IAddressBookService {
	private List<Person> addressBookList;

	public AddressBookService() {
		addressBookList = new ArrayList<>();
	}

	@Override
	public boolean addPerson(Person person) {
		return addressBookList.add(person);
	}

	@Override
	public boolean deletePerson(String name) {
		for (int i = 0; i < addressBookList.size(); i++) {
			if (addressBookList.get(i).name.equalsIgnoreCase(name)) {
				addressBookList.remove(i);
				return true;
			}
		}

		return false;
	}

	@Override
	public List<Person> getAddressBook() {
		return addressBookList;
	}

	public boolean editPerson(String contactName, Scanner scanner) {
		for (int i = 0; i < addressBookList.size(); i++) {

			if (addressBookList.get(i).name.equalsIgnoreCase(contactName))

			{
				System.out.println("Enter the FirstName");
				String name = scanner.next();

				System.out.println("Enter the Age");
				String age = scanner.next();

				System.out.println("Enter the Address");
				String address = scanner.next();

				System.out.println("Enter the City");
				String city = scanner.next();

				System.out.println("Enter the PinCode");
				String pincode = scanner.next();

				System.out.println("Enter the PhoneNo");
				String phoneNo = scanner.next();

				System.out.println("Enter the Email");
				String email = scanner.next();

				System.out.println("Enter the State");
				String state = scanner.next();

				addressBookList.get(i).setName(name);
				addressBookList.get(i).setAge(age);
				addressBookList.get(i).setCity(city);
				addressBookList.get(i).setAddress(address);
				addressBookList.get(i).setPhone(phoneNo);
				addressBookList.get(i).setZipcode(pincode);
				addressBookList.get(i).setEmail(email);
				addressBookList.get(i).setState(state);
				System.out.println("Updated list" + addressBookList.get(i));
			}

		}
		return false;

	}

	public void hasPresent(String n) {

		/*
		 * for (int i = 0; i < addressBookList.size(); i++) { if
		 * (addressBookList.get(i).name.equalsIgnoreCase(p)) { return true; } }
		 * 
		 * return false;
		 */

		List<Person> list2 = addressBookList.stream().filter(p -> p.getName().equalsIgnoreCase(n))
				.collect(Collectors.toList());

		if (list2.isEmpty()) {
			System.out.println("person details not exist");
		} else {
			System.out.println("Person details exist");
		}

	}

	@Override
	public void showByState(String s) {
		List<Person> list = addressBookList.stream().filter(p1 -> p1.getState().equalsIgnoreCase(s))
				.collect(Collectors.toList());

		System.out.println(list);

	}

	public void showByCity(String c) {
		List<Person> list1 = addressBookList.stream().filter(p -> p.getCity().equalsIgnoreCase(c))
				.collect(Collectors.toList());
		System.out.println(list1);

	}

	public int count() {
		int p = addressBookList.size();
		return p;

	}

	public int countContactByState(String p) {
		List<Person> list1 = addressBookList.stream().filter(c -> c.getState().equalsIgnoreCase(p))
				.collect(Collectors.toList());

		return list1.size();

	}

	public int countContactByCity(String p) {

		List<Person> list1 = addressBookList.stream().filter(c -> c.getCity().equalsIgnoreCase(p))
				.collect(Collectors.toList());

		return list1.size();

	}

	public void sortByName() {
		Collections.sort(addressBookList, Comparator.comparing(Person::getName));
		System.out.println(addressBookList);
	}

	public void sortByState() {
		Collections.sort(addressBookList, Comparator.comparing(Person::getState));
		System.out.println(addressBookList);
	}

	public void sortByCity() {
		Collections.sort(addressBookList, Comparator.comparing(Person::getCity));
		System.out.println(addressBookList);
	}

	public void sortByZip() {
		Collections.sort(addressBookList, Comparator.comparing(Person::getZip));
		System.out.println(addressBookList);
	}

}
