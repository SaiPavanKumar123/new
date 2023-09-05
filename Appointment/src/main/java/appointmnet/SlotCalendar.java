package appointmnet;

import java.sql.Time;
import java.util.Date;

public class SlotCalendar {
	int slotId;
	int slotDoctorid;
	Date slotdate;
	Time slotfrom;
	Time slotto;
	String slotstatus;

	public SlotCalendar(int slotId, int slotDoctorid, Date slotdate, Time slotfrom, Time slotto, String slotstatus) {

		this.slotId = slotId;
		this.slotDoctorid = slotDoctorid;
		this.slotdate = slotdate;
		this.slotfrom = slotfrom;
		this.slotto = slotto;
		this.slotstatus = slotstatus;
	}

	public SlotCalendar() {

	}

	public int getSlotId() {
		return slotId;
	}

	public int getSlotDoctorid() {
		return slotDoctorid;
	}

	public Date getSlotdate() {
		return slotdate;
	}

	public Time getSlotfrom() {
		return slotfrom;
	}

	public Time getSlotto() {
		return slotto;
	}

	public String getSlotstatus() {
		return slotstatus;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public void setSlotDoctorid(int slotDoctorid) {
		this.slotDoctorid = slotDoctorid;
	}

	public void setSlotdate(Date slotdate) {
		this.slotdate = slotdate;
	}

	public void setSlotfrom(Time slotfrom) {
		this.slotfrom = slotfrom;
	}

	public void setSlotto(Time slotto) {
		this.slotto = slotto;
	}

	public void setSlotstatus(String slotstatus) {
		this.slotstatus = slotstatus;
	}

}