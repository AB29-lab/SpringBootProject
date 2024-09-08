package com.tka.employeemanagementsystem.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.employeemanagementsystem.entity.Country;
import com.tka.employeemanagementsystem.entity.Employee;

@Repository
public class EmpDao {

	@Autowired
	SessionFactory factory;

	public String getCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country Added Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateCountry(int id, Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country cnt = session.get(Country.class, id);
			cnt.setCname(c.getCname());
			session.merge(cnt);
			tx.commit();
			msg = "Country is Updated";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteCountry(int cid) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country country = session.get(Country.class, cid);
			session.remove(country);
			tx.commit();
			msg = "Country Deleted Successfully...";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Country";
			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Country getParticularByID(int cid) {
		Session session = null;
		Transaction tx = null;
		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, cid);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;

	}

	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employee added Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee(int id, Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee e = session.get(Employee.class, id);
			e.setDepartment(emp.getDepartment());
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			e.setEmailid(emp.getEmailid());
			e.setMobileno(emp.getMobileno());
			e.setStatus(emp.getStatus());
			e.setCreatedBy(emp.getCreatedBy());
			e.setCreatedDate(emp.getCreatedDate());
			e.setUpdatedBy(emp.getUpdatedBy());
			e.setUpdatedDate(emp.getUpdatedDate());
			session.merge(e);
			tx.commit();
			msg = "Employee Updated Sucessfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String deleteEmployee(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee emp = session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg = "Employee Deleted Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public List<Employee> getAllRecord() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee";
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public Employee getParticularEmpByID(int id) {
		Session session = null;
		Transaction tx = null;
		Employee em = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			em = session.get(Employee.class, id);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return em;

	}

	public Employee loginCheck(Employee emp) {
		Session session = null;
		Transaction tx = null;
		Employee em = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where emailid=:myemail and mobileno=:mymob";
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("myemail", emp.getEmailid());
			query.setParameter("mymob", emp.getMobileno());
			em = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return em;

	}

	public List<Employee> getEmpSalary(double ssalary, double esalary) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where salary between :myssalary and :myesalary";
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("myssalary", ssalary);
			query.setParameter("myesalary", esalary);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public List<Employee> getStatus(String status) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where status=:mystatus";
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mystatus", status);
			list = query.list();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public String updateStatus(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee emp = session.get(Employee.class, id);

			if (Objects.isNull(emp)) {
				msg = "Record is not found...";
			} else {
				if (emp.getStatus().equalsIgnoreCase("Suspended")) {
					msg = "Status is not updated due to suspended...";
				} else {
					String status = "Active".equalsIgnoreCase(emp.getStatus()) ? "Inactive" : "Active";
					emp.setStatus(status);
					session.merge(emp);
					msg = "Status is updated...";
				}
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

}
