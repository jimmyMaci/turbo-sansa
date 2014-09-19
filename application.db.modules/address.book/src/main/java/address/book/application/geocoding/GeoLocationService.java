package address.book.application.geocoding;

import java.util.Map;

import org.jgeohash.GeoHashUtils;
import org.jgeohash.Point;
import org.jgeohash.distance.DistanceCalculator;
import org.jgeohash.distance.MeasuringUnit;

/**
 * The Class GeoLocationService is inspired from the internet
 * (http://xebee.xebia.in/2010/10/28/working-with-geolocations/). Extracted
 * comment from this blog:
 * ************************************************************************
 * Karthick, on February 7th, 2011 at 7:47 am Said:
 * 
 * Excellent, explanation/code. Perfectly matches what I was looking for. Thanks
 * for the blog entry.
 * 
 * Whats the license in which the code is released? It is free to use?
 * 
 * Thanks, Karhtick Robin Nagpal, on February 9th, 2011 at 8:51 am Said:
 * 
 * Yes, code is free to use ;)
 * ************************************************************************
 * 
 * @author Robin Nagpal
 */
public class GeoLocationService {

	/** The EART h_ radiu s_ km. */
	private static double EARTH_RADIUS_KM = 6371.009;

	public static final double DIAMETER_OF_EARTH = 6371.009 * 1000; //meters

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
//		Point p1 = new Point(1.723411, 178.2708026);
//		for (Point point : getExtremePointsFrom(p1, 300.00)) {
//			System.out.println("Extreme Point : " + point);
//			System.out.println("Distance from point  : "
//					+ DistanceCalculator.distanceBetweenPoints(((Position)p1), ((Position)point), MeasuringUnit.METER));
//		}
		String alterTeichwegGeohash = "u1x0v54r";
		Map<String, String> neighbors = GeoHashUtils.getAllAdjacentAreasMap(alterTeichwegGeohash);
		System.out.println("neighbors:"+neighbors);
		double[] coordinates = GeoHashUtils.decodeAndRound(alterTeichwegGeohash);
		Point alterTeichweg = new Point(coordinates[0], coordinates[1]);
		Point ludwigsburg = new Point(48.894169, 9.191870);
		for (Point point : getExtremePointsFrom(ludwigsburg, 300.00)) {
			System.out.println("Extreme Point : " + point);
			System.out.println("Distance from point  : "
					+ DistanceCalculator.distanceBetweenPoints(ludwigsburg, point, MeasuringUnit.METER));
		}
		double distance1 = DistanceCalculator.distanceBetweenPoints(ludwigsburg, alterTeichweg, MeasuringUnit.MILE);
		System.out.println("Distance1:"+distance1);
		
//		try {
//			String geohashOrgResult = Geocoder.getPlainTextResponse(alterTeichwegGeohash);
//			System.out.println("====================================");
//			System.out.println(geohashOrgResult);
//			System.out.println("====================================");
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * Converts the given value radians to degrees.
	 * 
	 * @param radians
	 *            the radians
	 * @return value in degrees
	 */
	private static double radiansToDegrees(final double radians) {
		return (radians * 180.0 / Math.PI);
	}

	/**
	 * Converts the given value from degrees to radians.
	 * 
	 * @param degrees
	 *            the degrees
	 * @return value in radians
	 */
	private static double degreesToRadians(final double degrees) {
		return (degrees * Math.PI / 180.0);
	}

	/**
	 * Returns the difference in degrees of longitude corresponding to the
	 * distance from the center point. This distance can be used to find the
	 * extreme points.
	 * 
	 * @param p1
	 *            the p1
	 * @param distance
	 *            the distance
	 * @return the extreme longitudes diff for point
	 */
	private static double getExtremeLongitudesDiffForPoint(final Point p1,
			final double distance) {
		double lat1 = p1.getLatitude();
		lat1 = degreesToRadians(lat1);
		double longitudeRadius = Math.cos(lat1) * EARTH_RADIUS_KM;
		double diffLong = (distance / longitudeRadius);
		diffLong = radiansToDegrees(diffLong);
		return diffLong;
	}

	/**
	 * Returns the difference in degrees of latitude corresponding to the
	 * distance from the center point. This distance can be used to find the
	 * extreme points.
	 * 
	 * @param p1
	 *            the p1
	 * @param distance
	 *            the distance
	 * @return the extreme latitudes diff for point
	 */
	private static double getExtremeLatitudesDiffForPoint(final Point p1,
			final double distance) {
		double latitudeRadians = distance / EARTH_RADIUS_KM;
		double diffLat = radiansToDegrees(latitudeRadians);
		return diffLat;
	}

	/**
	 * Returns an array of two extreme points corresponding to center point and
	 * the distance from the center point. These extreme points are the points
	 * with max/min latitude and longitude.
	 * 
	 * @param point
	 *            the point
	 * @param distance
	 *            the distance
	 * @return the extreme points from
	 */
	private static Point[] getExtremePointsFrom(final Point point,
			final Double distance) {
		double longDiff = getExtremeLongitudesDiffForPoint(point, distance);
		double latDiff = getExtremeLatitudesDiffForPoint(point, distance);
		Point p1 = new Point(point.getLatitude() - latDiff,
				point.getLongitude() - longDiff);
		Point p2 = new Point(point.getLatitude() + latDiff, point.getLatitude()
				+ longDiff);

		return new Point[] { p1, p2 };
	}
	


}