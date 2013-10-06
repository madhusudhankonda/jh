/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.hql;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class QueryTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("/hql/hibernate.cfg.xml");
//        config.addAnnotatedClass(TravelReview.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);

    }

    private void getAllTravelReviews() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();

        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview");
        List<TravelReview> reviews = query.list();

        for (TravelReview travelReview : reviews) {
            System.out.println("Travel Review: " + travelReview);
        }
        System.out.println("Method {getAllTravelReviews} results:" + reviews);

        tx.commit();
    }

    private void getAllTravelReviewsUsingChain() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();

        List<TravelReview> reviews = session.createQuery("from com.madhusudhan.jh.hql.TravelReview").list();

        System.out.println("Method {getAllTravelReviewsUsingChain} results:");

        for (TravelReview travelReview : reviews) {
            System.out.println("Travel Review: " + travelReview);
        }

        tx.commit();
    }

    private void getTravelReviewUniqueRecord() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview where title='London'");

        TravelReview review = (TravelReview) query.uniqueResult();
        System.out.println("Method {getTravelReviewUniqueRecord} results:" + review);
        tx.commit();

    }

    private void getTravelReviewWithQueryParam() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview where title=:titleId");
        query.setString("titleId", "London");
        TravelReview review = (TravelReview) query.uniqueResult();
        System.out.println("Method {getTravelReviewWithQueryParam} results:" + review);
        tx.commit();

    }

    private void getTravelReviewWithQueryParamList() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        List titleList = new ArrayList();
        titleList.add("London");
        titleList.add("Venice");
        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview where title in (:titleList)");
        query.setParameterList("titleList", titleList);;
        List<TravelReview> reviews = query.list();
        System.out.println("Method {getTravelReviewWithQueryParamList} results:" + reviews);
        tx.commit();

    }

    private void getTravelReviewWithMultiQueryParam() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview as tr where tr.title=? and tr.id=?");
        query.setString(0, "London");
        query.setInteger(1, 1);
//        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview where title=:titleId and id=:reviewId");
//        query.setString("titleId", "London");
//        query.setInteger("reviewId",1);
        TravelReview review = (TravelReview) query.uniqueResult();
        System.out.println("Method {getTravelReviewWithMultiQueryParam} results:" + review);
        tx.commit();

    }

    private void getTravelReviewWithSelect() {
        String SELECT_QUERY = "SELECT tr.review from com.madhusudhan.jh.hql.TravelReview as tr";

        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery(SELECT_QUERY);
//        query.setString("title", "London");
        List<String> reviews = query.list();
        System.out.println("Method {getTravelReviewWithSelect} results:");
        for (String review : reviews) {
            System.out.println("\t" + review);
        }
        tx.commit();
    }

    private void getTravelReviewWithSelectTuples() {
        String SELECT_QUERY_MULTIPLE_COLUMNS = "SELECT tr.title, tr.review from com.madhusudhan.jh.hql.TravelReview as tr";

        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery(SELECT_QUERY_MULTIPLE_COLUMNS);
        Iterator reviews = query.list().iterator();
        while (reviews.hasNext()) {
            Object[] r = (Object[]) reviews.next();
            System.out.print("Title:" + r[0] + "\t");
            System.out.println("Review:" + r[1]);
        }
        tx.commit();
    }

    private void getTravelReviewWithSelectNewObject() {
        String QUERY = "SELECT new com.madhusudhan.jh.hql.City(tr.title, tr.review ) from com.madhusudhan.jh.hql.TravelReview as tr";
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();

        List<City> cities = session.createQuery(QUERY).list();

        System.out.println("Method {getTravelReviewWithSelectNewObject} results:");
        for (City city : cities) {
            System.out.println("City: " + city);
        }
        tx.commit();
    }

    private void getTravelReviewWithFilters() {
        String SELECT_QUERY_MULTIPLE_COLUMNS = "from com.madhusudhan.jh.hql.TravelReview";

        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery(SELECT_QUERY_MULTIPLE_COLUMNS);
        List reviews = query.list();
//        List cities = session.createFilter(reviews, "where title='London'").list();
//        System.out.println("Method {getTravelReviewWithFilters} results:");
//
//        for (Object object : cities) {
//            System.out.println("Filtered Travel Review: "+object);
//        }
        tx.commit();
    }

    private void getTravelReviewWithQueryPagination() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();

        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview");
        query.setMaxResults(1);
        query.setFirstResult(2);
        List<TravelReview> reviews = query.list();
        System.out.println("Method {getTravelReviewWithQueryPagination} results:" + reviews);

        tx.commit();

    }

    private void getTravelReviewWithQuery() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();

        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview where title='" + "London'");
        List<TravelReview> reviews = query.list();

        for (TravelReview travelReview : reviews) {
            System.out.println("Travel Review: " + travelReview);
        }

        System.out.println("Method {getTravelReviewWithQuery} results:" + reviews);


        tx.commit();
    }

    private void getTravelReviewWithIterator() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        List titleList = new ArrayList();
        titleList.add("London");
        titleList.add("Venice");
        Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview");
        Iterator queryIter = query.list().iterator();
        while (queryIter.hasNext()) {
            TravelReview tr = (TravelReview) queryIter.next();
            System.out.println("Method {getTravelReviewWithIterator} results:" + tr);
            if (tr.getId() == 2) {
                System.out.println("Removing TravelReview from cache for " + tr.getTitle());
                queryIter.remove();
            }
        }
        tx.commit();

    }
    
    private void updateTravelReview() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("update com.madhusudhan.jh.hql.TravelReview set review=:review where id=2");
        query.setParameter("review", "The city with charm. The city you will never forget");
        int success = query.executeUpdate();
        System.out.println("Updated "+success);
        tx.commit();

    }

    private void deleteTravelReview() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("delete com.madhusudhan.jh.hql.TravelReview where id=6");
        int success = query.executeUpdate();
        System.out.println("delete success "+success);
        tx.commit();

    }

        private void usingNamedQueries() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Query query = session.getNamedQuery("GET_TRAVEL_REVIEWS");
        List reviews = query.list();
        System.out.println("Using Named Queries "+reviews);
        tx.commit();

    }

    private void usingCriteria() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Date fromDate = null;
        Date toDate = null;

        List review = null;
//        Criteria criteria = session.createCriteria(TravelReview.class)
//                .add(Restrictions.eq("author", "John Jones"))
//                .add(Restrictions.between("date",fromDate,toDate))
//                .add(Restrictions.ne("title","New York"));
//
//        review = session.createCriteria(TravelReview.class)
//                .add(Restrictions.eq("author", "John Jones"))
//                .add(Restrictions.between("date",fromDate,toDate))
//                .add(Restrictions.ne("title","New York")).list();

        
        System.out.println("Row Count: " + review);

        tx.commit();

    }

    private void usingProjections() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        
//        List review = session.createCriteria(TravelReview.class)
//                .setProjection(Projections.rowCount())
//                .list();

        List review = session.createCriteria(TravelReview.class)
                .setProjection(Projections.property("title"))
                .list();
        System.out.println("List of tiles (using Projections): "+review);

        review = session.createCriteria(TravelReview.class)
                .setProjection(Projections.count("title"))
                .list();
        
        System.out.println("Count of titles: (using Projections):"+review);

        review = session.createCriteria(TravelReview.class)
                .setProjection(Projections.rowCount())
                .list();

        tx.commit();
        System.out.println("Row count: (using Projections):"+review);

    }

    private void usingAggregateFunctions() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        
        List review = session.createQuery("select max(ticket_price) from TravelFlight").list();
        System.out.println("List of tiles (using Projections): "+review);

        review = session.createCriteria(TravelReview.class)
                .setProjection(Projections.count("title"))
                .list();
        
        System.out.println("Count of titles: (using Projections):"+review);

        review = session.createCriteria(TravelReview.class)
                .setProjection(Projections.rowCount())
                .list();
        
        System.out.println("Row count: (using Projections):"+review);

    }

    private void populateMovies() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();

        List<TravelReview> reviews = createReviewSamples();

        for (TravelReview travelReview : reviews) {
            session.save(travelReview);
        }
        tx.commit();

    }

    private List<TravelReview> createReviewSamples() {
        List<TravelReview> reviews = new ArrayList<TravelReview>();
        TravelReview review = new TravelReview();
//
//        review.setTitle("London");
//        review.setReview("One of the best city you must visit before you die.");
//        reviews.add(review);
//
//        review = new TravelReview();
//        review.setTitle("Austria");
//        review.setReview("Sound of Music!.");
//        reviews.add(review);
//
//        review = new TravelReview();
//        review.setTitle("Venice");
//        review.setReview("Best island on water, although a bit expensive");
//        reviews.add(review);

        review = new TravelReview();
        review.setTitle("New York");
        review.setReview("The city that never sleeps!");
        reviews.add(review);

        return reviews;
    }

    public static void main(String[] args) {
        QueryTest test = new QueryTest();
        test.init();
//        test.populateMovies();

        test.getAllTravelReviews();
        test.getAllTravelReviewsUsingChain();
        test.getTravelReviewUniqueRecord();
        test.getTravelReviewWithQuery();
        test.getTravelReviewWithQueryParam();
        test.getTravelReviewWithQueryParamList();
        test.getTravelReviewWithQueryPagination();
        test.getTravelReviewWithMultiQueryParam();

        test.getTravelReviewWithSelect();
        test.getTravelReviewWithIterator();
        test.getTravelReviewWithSelectTuples();
        test.getTravelReviewWithSelectNewObject();
        test.getTravelReviewWithFilters();
//        test.updateTravelReview();
        test.deleteTravelReview();
        test.usingCriteria();
        test.usingProjections();
        test.usingNamedQueries();
    }
}
