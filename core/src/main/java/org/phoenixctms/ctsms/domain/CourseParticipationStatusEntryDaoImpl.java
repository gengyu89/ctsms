// Generated by: hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.phoenixctms.ctsms.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.phoenixctms.ctsms.enumeration.VariablePeriod;
import org.phoenixctms.ctsms.pdf.CVPDFDefaultSettings;
import org.phoenixctms.ctsms.pdf.CVPDFLabelCodes;
import org.phoenixctms.ctsms.pdf.CVPDFSettingCodes;
import org.phoenixctms.ctsms.query.CriteriaUtil;
import org.phoenixctms.ctsms.query.SubCriteriaMap;
import org.phoenixctms.ctsms.util.CommonUtil;
import org.phoenixctms.ctsms.util.L10nUtil;
import org.phoenixctms.ctsms.util.L10nUtil.Locales;
import org.phoenixctms.ctsms.util.ServiceUtil;
import org.phoenixctms.ctsms.util.Settings;
import org.phoenixctms.ctsms.util.Settings.Bundle;
import org.phoenixctms.ctsms.vo.CourseOutVO;
import org.phoenixctms.ctsms.vo.CourseParticipationStatusEntryInVO;
import org.phoenixctms.ctsms.vo.CourseParticipationStatusEntryOutVO;
import org.phoenixctms.ctsms.vo.CourseParticipationStatusTypeVO;
import org.phoenixctms.ctsms.vo.CvPositionPDFVO;
import org.phoenixctms.ctsms.vo.CvSectionVO;
import org.phoenixctms.ctsms.vo.PSFVO;
import org.phoenixctms.ctsms.vo.StaffOutVO;
import org.phoenixctms.ctsms.vo.TrainingRecordSectionVO;
import org.phoenixctms.ctsms.vo.UserOutVO;

/**
 * @see CourseParticipationStatusEntry
 */
public class CourseParticipationStatusEntryDaoImpl
		extends CourseParticipationStatusEntryDaoBase {

	/**
	 * @inheritDoc
	 */
	@Override
	public CourseParticipationStatusEntry courseParticipationStatusEntryInVOToEntity(CourseParticipationStatusEntryInVO courseParticipationStatusEntryInVO) {
		CourseParticipationStatusEntry entity = this.loadCourseParticipationStatusEntryFromCourseParticipationStatusEntryInVO(courseParticipationStatusEntryInVO);
		this.courseParticipationStatusEntryInVOToEntity(courseParticipationStatusEntryInVO, entity, true);
		return entity;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void courseParticipationStatusEntryInVOToEntity(
			CourseParticipationStatusEntryInVO source,
			CourseParticipationStatusEntry target,
			boolean copyIfNull) {
		super.courseParticipationStatusEntryInVOToEntity(source, target, copyIfNull);
		Long cvSectionId = source.getCvSectionId();
		Long trainingRecordSectionId = source.getTrainingRecordSectionId();
		Long courseId = source.getCourseId();
		Long statusId = source.getStatusId();
		Long staffId = source.getStaffId();
		if (cvSectionId != null) {
			target.setCvSection(this.getCvSectionDao().load(cvSectionId));
		} else if (copyIfNull) {
			target.setCvSection(null);
		}
		if (trainingRecordSectionId != null) {
			target.setTrainingRecordSection(this.getTrainingRecordSectionDao().load(trainingRecordSectionId));
		} else if (copyIfNull) {
			target.setTrainingRecordSection(null);
		}
		if (courseId != null) {
			Course course = this.getCourseDao().load(courseId);
			target.setCourse(course);
			course.addParticipations(target);
		} else if (copyIfNull) {
			Course course = target.getCourse();
			target.setCourse(null);
			if (course != null) {
				course.removeParticipations(target);
			}
		}
		if (statusId != null) {
			target.setStatus(this.getCourseParticipationStatusTypeDao().load(statusId));
		} else if (copyIfNull) {
			target.setStatus(null);
		}
		if (staffId != null) {
			Staff staff = this.getStaffDao().load(staffId);
			target.setStaff(staff);
			staff.addParticipations(target);
		} else if (copyIfNull) {
			Staff staff = target.getStaff();
			target.setStaff(null);
			if (staff != null) {
				staff.removeParticipations(target);
			}
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public CourseParticipationStatusEntry courseParticipationStatusEntryOutVOToEntity(CourseParticipationStatusEntryOutVO courseParticipationStatusEntryOutVO) {
		CourseParticipationStatusEntry entity = this.loadCourseParticipationStatusEntryFromCourseParticipationStatusEntryOutVO(courseParticipationStatusEntryOutVO);
		this.courseParticipationStatusEntryOutVOToEntity(courseParticipationStatusEntryOutVO, entity, true);
		return entity;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void courseParticipationStatusEntryOutVOToEntity(
			CourseParticipationStatusEntryOutVO source,
			CourseParticipationStatusEntry target,
			boolean copyIfNull) {
		super.courseParticipationStatusEntryOutVOToEntity(source, target, copyIfNull);
		CvSectionVO cvSectionVO = source.getCvSection();
		TrainingRecordSectionVO trainingRecordSectionVO = source.getTrainingRecordSection();
		CourseOutVO courseVO = source.getCourse();
		StaffOutVO staffVO = source.getStaff();
		CourseParticipationStatusTypeVO statusVO = source.getStatus();
		UserOutVO modifiedUserVO = source.getModifiedUser();
		if (cvSectionVO != null) {
			target.setCvSection(this.getCvSectionDao().cvSectionVOToEntity(cvSectionVO));
		} else if (copyIfNull) {
			target.setCvSection(null);
		}
		if (trainingRecordSectionVO != null) {
			target.setTrainingRecordSection(this.getTrainingRecordSectionDao().trainingRecordSectionVOToEntity(trainingRecordSectionVO));
		} else if (copyIfNull) {
			target.setTrainingRecordSection(null);
		}
		if (courseVO != null) {
			Course course = this.getCourseDao().courseOutVOToEntity(courseVO);
			target.setCourse(course);
			course.addParticipations(target);
		} else if (copyIfNull) {
			Course course = target.getCourse();
			target.setCourse(null);
			if (course != null) {
				course.removeParticipations(target);
			}
		}
		if (statusVO != null) {
			target.setStatus(this.getCourseParticipationStatusTypeDao().courseParticipationStatusTypeVOToEntity(statusVO));
		} else if (copyIfNull) {
			target.setStatus(null);
		}
		if (staffVO != null) {
			Staff staff = this.getStaffDao().staffOutVOToEntity(staffVO);
			target.setStaff(staff);
			staff.addParticipations(target);
		} else if (copyIfNull) {
			Staff staff = target.getStaff();
			target.setStaff(null);
			if (staff != null) {
				staff.removeParticipations(target);
			}
		}
		if (modifiedUserVO != null) {
			target.setModifiedUser(this.getUserDao().userOutVOToEntity(modifiedUserVO));
		} else if (copyIfNull) {
			target.setModifiedUser(null);
		}
	}

	private org.hibernate.Criteria createCourseParticipationStatusEntryCriteria() {
		org.hibernate.Criteria courseParticipationStatusEntryCriteria = this.getSession().createCriteria(CourseParticipationStatusEntry.class);
		return courseParticipationStatusEntryCriteria;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public CourseParticipationStatusEntry cvPositionPDFVOToEntity(CvPositionPDFVO cvPositionPDFVO) {
		CourseParticipationStatusEntry entity = this.loadCourseParticipationStatusEntryFromCvPositionPDFVO(cvPositionPDFVO);
		this.cvPositionPDFVOToEntity(cvPositionPDFVO, entity, true);
		return entity;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void cvPositionPDFVOToEntity(
			CvPositionPDFVO source,
			CourseParticipationStatusEntry target,
			boolean copyIfNull) {
		super.cvPositionPDFVOToEntity(source, target, copyIfNull);
	}

	@Override
	protected Collection<CourseParticipationStatusEntry> handleFindByCourseSorted(
			Long courseId) throws Exception {
		org.hibernate.Criteria courseParticipationStatusEntryCriteria = createCourseParticipationStatusEntryCriteria();
		if (courseId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("course.id", courseId.longValue()));
		}
		Criteria staffCriteria = courseParticipationStatusEntryCriteria.createCriteria("staff", CriteriaSpecification.INNER_JOIN);
		Criteria personParticularsCriteria = staffCriteria.createCriteria("personParticulars", CriteriaSpecification.INNER_JOIN);
		personParticularsCriteria.addOrder(Order.asc("lastName"));
		personParticularsCriteria.addOrder(Order.asc("firstName"));
		return courseParticipationStatusEntryCriteria.list();
	}

	@Override
	protected Collection<CourseParticipationStatusEntry> handleFindByStaffCourseRelevantForCourseAppointments(Long staffId, Long courseId, Boolean isRelevantForCourseAppointments)
			throws Exception {
		org.hibernate.Criteria courseParticipationStatusEntryCriteria = createCourseParticipationStatusEntryCriteria();
		if (staffId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("staff.id", staffId.longValue()));
		}
		if (courseId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("course.id", courseId.longValue()));
		}
		if (isRelevantForCourseAppointments != null) {
			courseParticipationStatusEntryCriteria.createCriteria("status", CriteriaSpecification.INNER_JOIN).add(
					Restrictions.eq("relevantForCourseAppointments", isRelevantForCourseAppointments.booleanValue()));
		}
		return courseParticipationStatusEntryCriteria.list();
	}

	@Override
	protected Collection<CourseParticipationStatusEntry> handleFindByStaffCourseStatus(
			Long staffId, Long courseId, Long statusId, PSFVO psf)
			throws Exception {
		org.hibernate.Criteria courseParticipationStatusEntryCriteria = createCourseParticipationStatusEntryCriteria();
		SubCriteriaMap criteriaMap = new SubCriteriaMap(CourseParticipationStatusEntry.class, courseParticipationStatusEntryCriteria);
		if (staffId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("staff.id", staffId.longValue()));
		}
		if (courseId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("course.id", courseId.longValue()));
		}
		if (statusId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("status.id", statusId.longValue()));
		}
		CriteriaUtil.applyPSFVO(criteriaMap, psf);
		return courseParticipationStatusEntryCriteria.list();
	}

	/**
	 * @inheritDoc
	 */
	@Override
	protected Collection<CourseParticipationStatusEntry> handleFindByStaffCvSection(Long staffId, Long cvSectionId, Boolean showCv, Boolean pass, Boolean showCvPreset, PSFVO psf)
			throws Exception {
		org.hibernate.Criteria courseParticipationStatusEntryCriteria = createCourseParticipationStatusEntryCriteria();
		SubCriteriaMap criteriaMap = new SubCriteriaMap(CourseParticipationStatusEntry.class, courseParticipationStatusEntryCriteria);
		if (staffId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("staff.id", staffId.longValue()));
		}
		if (showCvPreset != null) {
			criteriaMap.createCriteria("course").add(Restrictions.eq("showCvPreset", showCvPreset.booleanValue()));
		}
		if (cvSectionId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("cvSection.id", cvSectionId.longValue()));
		}
		if (showCv != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("showCv", showCv.booleanValue()));
		}
		if (pass != null) {
			criteriaMap.createCriteria("status").add(Restrictions.eq("pass", pass.booleanValue()));
		}
		CriteriaUtil.applyPSFVO(criteriaMap, psf);
		return courseParticipationStatusEntryCriteria.list();
	}

	@Override
	protected Collection<CourseParticipationStatusEntry> handleFindByStaffTrialsTrainingRecordSection(Long staffId, Set<Long> trialIds, Long trainingRecordSectionId,
			Boolean showTrainingRecord,
			Boolean pass, Boolean showTrainingRecordPreset, PSFVO psf)
			throws Exception {
		org.hibernate.Criteria courseParticipationStatusEntryCriteria = createCourseParticipationStatusEntryCriteria();
		SubCriteriaMap criteriaMap = new SubCriteriaMap(CourseParticipationStatusEntry.class, courseParticipationStatusEntryCriteria);
		if (staffId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("staff.id", staffId.longValue()));
		}
		if (trialIds != null && trialIds.size() > 0) {
			criteriaMap.createCriteria("course").add(Restrictions.in("trial.id", trialIds));
		}
		if (showTrainingRecordPreset != null) {
			criteriaMap.createCriteria("course").add(Restrictions.eq("showTrainingRecordPreset", showTrainingRecordPreset.booleanValue()));
		}
		if (trainingRecordSectionId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("trainingRecordSection.id", trainingRecordSectionId.longValue()));
		}
		if (showTrainingRecord != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("showTrainingRecord", showTrainingRecord.booleanValue()));
		}
		if (pass != null) {
			criteriaMap.createCriteria("status").add(Restrictions.eq("pass", pass.booleanValue()));
		}
		CriteriaUtil.applyPSFVO(criteriaMap, psf);
		return courseParticipationStatusEntryCriteria.list();
	}

	@Override
	protected Collection<CourseParticipationStatusEntry> handleFindExpiring(Date today,
			Long courseDepartmentId, Long courseCategoryId,
			Long staffDepartmentId, Long staffCategoryId,
			Long staffId, Boolean employee, VariablePeriod reminderPeriod, Long reminderPeriodDays, boolean includeAlreadyPassed, PSFVO psf)
			throws Exception {
		org.hibernate.Criteria courseParticipationStatusEntryCriteria = createCourseParticipationStatusEntryCriteria();
		SubCriteriaMap criteriaMap = new SubCriteriaMap(CourseParticipationStatusEntry.class, courseParticipationStatusEntryCriteria);
		if (staffId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("staff.id", staffId.longValue()));
		}
		if (employee != null) {
			criteriaMap.createCriteria("staff").add(Restrictions.eq("employee", employee.booleanValue()));
		}
		if (staffDepartmentId != null) {
			criteriaMap.createCriteria("staff").add(Restrictions.eq("department.id", staffDepartmentId.longValue()));
		}
		if (staffCategoryId != null) {
			criteriaMap.createCriteria("staff").add(Restrictions.eq("category.id", staffCategoryId.longValue()));
		}
		criteriaMap.createCriteria("course").add(Restrictions.eq("expires", true)); // performance only...
		if (courseDepartmentId != null) {
			criteriaMap.createCriteria("course").add(Restrictions.eq("department.id", courseDepartmentId.longValue()));
		}
		if (courseCategoryId != null) {
			criteriaMap.createCriteria("course").add(Restrictions.eq("category.id", courseCategoryId.longValue()));
		}
		if (psf != null) {
			PSFVO sorterFilter = new PSFVO();
			sorterFilter.setFilters(psf.getFilters());
			sorterFilter.setSortField(psf.getSortField());
			sorterFilter.setSortOrder(psf.getSortOrder());
			CriteriaUtil.applyPSFVO(criteriaMap, sorterFilter);
		}
		HashMap<Long, Set<Long>> particiaptionCourseIdsMap = new HashMap<Long, Set<Long>>();
		ArrayList<CourseParticipationStatusEntry> resultSet = CriteriaUtil.listExpirations(courseParticipationStatusEntryCriteria, today, null, includeAlreadyPassed, null, null,
				reminderPeriod,
				reminderPeriodDays, particiaptionCourseIdsMap);
		return CriteriaUtil.applyPVO(resultSet, psf, true); // eliminated dupes
	}

	@Override
	protected long handleGetStaffCourseStatusCount(
			Long staffId, Long courseId, Long statusId)
			throws Exception {
		org.hibernate.Criteria courseParticipationStatusEntryCriteria = createCourseParticipationStatusEntryCriteria();
		if (staffId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("staff.id", staffId.longValue()));
		}
		if (courseId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("course.id", courseId.longValue()));
		}
		if (statusId != null) {
			courseParticipationStatusEntryCriteria.add(Restrictions.eq("status.id", statusId.longValue()));
		}
		return (Long) courseParticipationStatusEntryCriteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * Retrieves the entity object that is associated with the specified value object
	 * from the object store. If no such entity object exists in the object store,
	 * a new, blank entity is created
	 */
	private CourseParticipationStatusEntry loadCourseParticipationStatusEntryFromCourseParticipationStatusEntryInVO(
			CourseParticipationStatusEntryInVO courseParticipationStatusEntryInVO) {
		CourseParticipationStatusEntry courseParticipationStatusEntry = null;
		Long id = courseParticipationStatusEntryInVO.getId();
		if (id != null) {
			courseParticipationStatusEntry = this.load(id);
		}
		if (courseParticipationStatusEntry == null) {
			courseParticipationStatusEntry = CourseParticipationStatusEntry.Factory.newInstance();
		}
		return courseParticipationStatusEntry;
	}

	/**
	 * Retrieves the entity object that is associated with the specified value object
	 * from the object store. If no such entity object exists in the object store,
	 * a new, blank entity is created
	 */
	private CourseParticipationStatusEntry loadCourseParticipationStatusEntryFromCourseParticipationStatusEntryOutVO(
			CourseParticipationStatusEntryOutVO courseParticipationStatusEntryOutVO) {
		CourseParticipationStatusEntry courseParticipationStatusEntry = this.load(courseParticipationStatusEntryOutVO.getId());
		if (courseParticipationStatusEntry == null) {
			courseParticipationStatusEntry = CourseParticipationStatusEntry.Factory.newInstance();
		}
		return courseParticipationStatusEntry;
	}

	/**
	 * Retrieves the entity object that is associated with the specified value object
	 * from the object store. If no such entity object exists in the object store,
	 * a new, blank entity is created
	 */
	private CourseParticipationStatusEntry loadCourseParticipationStatusEntryFromCvPositionPDFVO(CvPositionPDFVO cvPositionPDFVO) {
		throw new UnsupportedOperationException("org.phoenixctms.ctsms.domain.loadCourseParticipationStatusEntryFromCvPositionPDFVO(CvPositionPDFVO) not yet implemented.");
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public CourseParticipationStatusEntryInVO toCourseParticipationStatusEntryInVO(final CourseParticipationStatusEntry entity) {
		return super.toCourseParticipationStatusEntryInVO(entity);
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void toCourseParticipationStatusEntryInVO(
			CourseParticipationStatusEntry source,
			CourseParticipationStatusEntryInVO target) {
		super.toCourseParticipationStatusEntryInVO(source, target);
		CvSection cvSection = source.getCvSection();
		TrainingRecordSection trainingRecordSection = source.getTrainingRecordSection();
		Course course = source.getCourse();
		CourseParticipationStatusType status = source.getStatus();
		Staff staff = source.getStaff();
		if (cvSection != null) {
			target.setCvSectionId(cvSection.getId());
		}
		if (trainingRecordSection != null) {
			target.setTrainingRecordSectionId(trainingRecordSection.getId());
		}
		if (course != null) {
			target.setCourseId(course.getId());
		}
		if (status != null) {
			target.setStatusId(status.getId());
		}
		if (staff != null) {
			target.setStaffId(staff.getId());
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public CourseParticipationStatusEntryOutVO toCourseParticipationStatusEntryOutVO(final CourseParticipationStatusEntry entity) {
		return super.toCourseParticipationStatusEntryOutVO(entity);
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void toCourseParticipationStatusEntryOutVO(
			CourseParticipationStatusEntry source,
			CourseParticipationStatusEntryOutVO target) {
		super.toCourseParticipationStatusEntryOutVO(source, target);
		CvSection cvSection = source.getCvSection();
		TrainingRecordSection trainingRecordSection = source.getTrainingRecordSection();
		Course course = source.getCourse();
		Staff staff = source.getStaff();
		CourseParticipationStatusType status = source.getStatus();
		User modifiedUser = source.getModifiedUser();
		if (cvSection != null) {
			target.setCvSection(this.getCvSectionDao().toCvSectionVO(cvSection));
		}
		if (trainingRecordSection != null) {
			target.setTrainingRecordSection(this.getTrainingRecordSectionDao().toTrainingRecordSectionVO(trainingRecordSection));
		}
		if (course != null) {
			target.setCourse(this.getCourseDao().toCourseOutVO(course));
		}
		if (staff != null) {
			target.setStaff(this.getStaffDao().toStaffOutVO(staff));
		}
		if (status != null) {
			target.setStatus(this.getCourseParticipationStatusTypeDao().toCourseParticipationStatusTypeVO(status));
		}
		if (modifiedUser != null) {
			target.setModifiedUser(this.getUserDao().toUserOutVO(modifiedUser));
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public CvPositionPDFVO toCvPositionPDFVO(final CourseParticipationStatusEntry entity) {
		return super.toCvPositionPDFVO(entity);
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void toCvPositionPDFVO(
			CourseParticipationStatusEntry source,
			CvPositionPDFVO target) {
		super.toCvPositionPDFVO(source, target);
		CvSection cvSection = source.getCvSection();
		Course course = source.getCourse();
		if (cvSection != null) {
			target.setSection(this.getCvSectionDao().toCvSectionVO(cvSection));
		}
		if (course != null) {
			StringBuilder sb = new StringBuilder();
			if (CommonUtil.isEmptyString(course.getCvTitle())) {
				sb.append(course.getName());
			} else {
				sb.append(course.getCvTitle());
			}
			sb.append(L10nUtil.getCVPDFLabel(
					Locales.CV_PDF,
					CVPDFLabelCodes.POSITION_COURSE_DATE,
					CVPDFDefaultSettings.POSITION_COURSE_DATE_LABEL,
					Settings.getSimpleDateFormat(CVPDFSettingCodes.POSITION_DATE_PATTERN, Bundle.CV_PDF, CVPDFDefaultSettings.POSITION_DATE_PATTERN, Locales.CV_PDF).format(
							course.getStop())));
			target.setLabel1(sb.toString());
			Staff institution = course.getInstitution();
			if (institution != null) {
				target.setLabel2(ServiceUtil.getCvStaffPathString(this.getStaffDao().toStaffOutVO(institution,
						Settings.getInt(CVPDFSettingCodes.GRAPH_MAX_STAFF_INSTANCES, Bundle.CV_PDF, CVPDFDefaultSettings.GRAPH_MAX_STAFF_INSTANCES))));
			}
			target.setStart(null);
			target.setStop(course.getStop());
		}
		if (source.isShowCommentCv()) {
			String comment = source.getComment();
			if (comment != null && comment.length() > 0) {
				target.setLabel3(comment);
			}
		}
		target.setCourseParticipation(true);
	}
}