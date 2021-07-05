package com.ADLP.api.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class Summary {
	@Id  
	private String _id;
	
//	@Field("average_acc")
	private double average_acc;

	@Field("average_speed")
	private int average_speed;
	
	@Field("dtc_code")
	private String dtc_code;
	
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private Double[] end_lat_long;
	
	@Field("end_odometer")
	private int end_odometer;
	
	@Field("end_timestamp")
	private Date end_timestamp;
	
	@Field("harsh_breaking")
	private int harsh_braking;
	
	@Field("impact_event")
	private String impact_event;
	
	@Field("overspeeding_120")
	private int overspeeding_120;
	
	@Field("overspeeding_80")
	private int overspeeding_80;
	
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private Double[] start_lat_long;
	
	@Field("start_odometer")
	private int start_odometer;
	

    @Temporal(TemporalType.TIMESTAMP)
	private Date start_timestamp;
	
	@Field("trip_distance")
	private int trip_distance;
	
	@Field("trip_id")
	private String trip_id;
	
	@Field("type")
	private String type;
	
	@Field("tyre_status")
	private String tyre_status;
	
	@Field("vehicle_id")
	private String vehicle_id;
	
	@Field("vehicle_oem")
	private String vehicle_oem;
	
	@Field("vehicle_type")
	private String vehicle_type;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Double getAverage_acc() {
		return average_acc;
	}

	public void setAverage_acc(Double average_acc) {
		this.average_acc = average_acc;
	}

	public int getAverage_speed() {
		return average_speed;
	}

	public void setAverage_speed(int average_speed) {
		this.average_speed = average_speed;
	}

	public String getDtc_code() {
		return dtc_code;
	}

	public void setDtc_code(String dtc_code) {
		this.dtc_code = dtc_code;
	}

	public Double[] getEnd_lat_long() {
		return end_lat_long;
	}

	public void setEnd_lat_long(Double[] end_lat_long) {
		this.end_lat_long = end_lat_long;
	}

	public int getEnd_odometer() {
		return end_odometer;
	}

	public void setEnd_odometer(int end_odometer) {
		this.end_odometer = end_odometer;
	}

	public Date getEnd_timestamp() {
		return end_timestamp;
	}

	public void setEnd_timestamp(Date end_timestamp) {
		this.end_timestamp = end_timestamp;
	}

	public int getHarsh_braking() {
		return harsh_braking;
	}

	public void setHarsh_braking(int harsh_braking) {
		this.harsh_braking = harsh_braking;
	}

	public String getImpact_event() {
		return impact_event;
	}

	public void setImpact_event(String impact_event) {
		this.impact_event = impact_event;
	}

	public int getOverspeeding_120() {
		return overspeeding_120;
	}

	public void setOverspeeding_120(int overspeeding_120) {
		this.overspeeding_120 = overspeeding_120;
	}

	public int getOverspeeding_80() {
		return overspeeding_80;
	}

	public void setOverspeeding_80(int overspeeding_80) {
		this.overspeeding_80 = overspeeding_80;
	}

	public Double[] getStart_lat_long() {
		return start_lat_long;
	}

	public void setStart_lat_long(Double[] start_lat_long) {
		this.start_lat_long = start_lat_long;
	}

	public int getStart_odometer() {
		return start_odometer;
	}

	public void setStart_odometer(int start_odometer) {
		this.start_odometer = start_odometer;
	}

	public Date getStart_timestamp() {
		return start_timestamp;
	}

	public void setStart_timestamp(Date start_timestamp) {
		this.start_timestamp = start_timestamp;
	}

	public int getTrip_distance() {
		return trip_distance;
	}

	public void setTrip_distance(int trip_distance) {
		this.trip_distance = trip_distance;
	}

	public String getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTyre_status() {
		return tyre_status;
	}

	public void setTyre_status(String tyre_status) {
		this.tyre_status = tyre_status;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVehicle_oem() {
		return vehicle_oem;
	}

	public void setVehicle_oem(String vehicle_oem) {
		this.vehicle_oem = vehicle_oem;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	@Override
	public String toString() {
		return "Summary [_id=" + _id + ", average_acc=" + average_acc + ", average_speed=" + average_speed
				+ ", dtc_code=" + dtc_code + ", end_lat_long=" + Arrays.toString(end_lat_long) + ", end_odometer="
				+ end_odometer + ", end_timestamp=" + end_timestamp + ", harsh_braking=" + harsh_braking
				+ ", impact_event=" + impact_event + ", overspeeding_120=" + overspeeding_120 + ", overspeeding_80="
				+ overspeeding_80 + ", start_lat_long=" + Arrays.toString(start_lat_long) + ", start_odometer="
				+ start_odometer + ", start_timestamp=" + start_timestamp + ", trip_distance=" + trip_distance
				+ ", trip_id=" + trip_id + ", type=" + type + ", tyre_status=" + tyre_status + ", vehicle_id="
				+ vehicle_id + ", vehicle_oem=" + vehicle_oem + ", vehicle_type=" + vehicle_type + "]";
	}

	public Summary(String _id, Double average_acc, int average_speed, String dtc_code, Double[] end_lat_long,
			int end_odometer, Date end_timestamp, int harsh_braking, String impact_event, int overspeeding_120,
			int overspeeding_80, Double[] start_lat_long, int start_odometer, Date start_timestamp, int trip_distance,
			String trip_id, String type, String tyre_status, String vehicle_id, String vehicle_oem,
			String vehicle_type) {
		super();
		this._id = _id;
		this.average_acc = average_acc;
		this.average_speed = average_speed;
		this.dtc_code = dtc_code;
		this.end_lat_long = end_lat_long;
		this.end_odometer = end_odometer;
		this.end_timestamp = end_timestamp;
		this.harsh_braking = harsh_braking;
		this.impact_event = impact_event;
		this.overspeeding_120 = overspeeding_120;
		this.overspeeding_80 = overspeeding_80;
		this.start_lat_long = start_lat_long;
		this.start_odometer = start_odometer;
		this.start_timestamp = start_timestamp;
		this.trip_distance = trip_distance;
		this.trip_id = trip_id;
		this.type = type;
		this.tyre_status = tyre_status;
		this.vehicle_id = vehicle_id;
		this.vehicle_oem = vehicle_oem;
		this.vehicle_type = vehicle_type;
	}

	public Summary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
