// Generated by: hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.phoenixctms.ctsms.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.phoenixctms.ctsms.query.CriteriaUtil;
import org.phoenixctms.ctsms.query.SubCriteriaMap;
import org.phoenixctms.ctsms.security.CipherText;
import org.phoenixctms.ctsms.security.CryptoUtil;
import org.phoenixctms.ctsms.security.reencrypt.FieldReEncrypter;
import org.phoenixctms.ctsms.security.reencrypt.ReEncrypter;
import org.phoenixctms.ctsms.util.CoreUtil;
import org.phoenixctms.ctsms.vo.ContactDetailTypeVO;
import org.phoenixctms.ctsms.vo.PSFVO;
import org.phoenixctms.ctsms.vo.ProbandContactDetailValueInVO;
import org.phoenixctms.ctsms.vo.ProbandContactDetailValueOutVO;
import org.phoenixctms.ctsms.vo.ProbandOutVO;
import org.phoenixctms.ctsms.vo.UserOutVO;

/**
 * @see ProbandContactDetailValue
 */
public class ProbandContactDetailValueDaoImpl
		extends ProbandContactDetailValueDaoBase {

	private final static Collection<ReEncrypter<ProbandContactDetailValue>> RE_ENCRYPTERS = new ArrayList<ReEncrypter<ProbandContactDetailValue>>();
	static {
		RE_ENCRYPTERS.add(new FieldReEncrypter<ProbandContactDetailValue>() {

			@Override
			protected byte[] getIv(ProbandContactDetailValue item) {
				return item.getValueIv();
			}

			@Override
			protected byte[] getEncrypted(ProbandContactDetailValue item) {
				return item.getEncryptedValue();
			}

			@Override
			protected void setIv(ProbandContactDetailValue item, byte[] iv) {
				item.setValueIv(iv);
			}

			@Override
			protected void setEncrypted(ProbandContactDetailValue item, byte[] cipherText) {
				item.setEncryptedValue(cipherText);
			}

			@Override
			protected void setHash(ProbandContactDetailValue item, byte[] hash) {
				item.setValueHash(hash);
			}
		});
		RE_ENCRYPTERS.add(new FieldReEncrypter<ProbandContactDetailValue>() {

			@Override
			protected byte[] getIv(ProbandContactDetailValue item) {
				return item.getCommentIv();
			}

			@Override
			protected byte[] getEncrypted(ProbandContactDetailValue item) {
				return item.getEncryptedComment();
			}

			@Override
			protected void setIv(ProbandContactDetailValue item, byte[] iv) {
				item.setCommentIv(iv);
			}

			@Override
			protected void setEncrypted(ProbandContactDetailValue item, byte[] cipherText) {
				item.setEncryptedComment(cipherText);
			}

			@Override
			protected void setHash(ProbandContactDetailValue item, byte[] hash) {
				item.setCommentHash(hash);
			}
		});
	}

	@Override
	protected Collection<ReEncrypter<ProbandContactDetailValue>> getReEncrypters() {
		return RE_ENCRYPTERS;
	}

	private org.hibernate.Criteria createContactDetailValueCriteria() {
		org.hibernate.Criteria contactDetailValueCriteria = this.getSession().createCriteria(ProbandContactDetailValue.class);
		return contactDetailValueCriteria;
	}

	@Override
	protected Collection<ProbandContactDetailValue> handleFindByProband(
			Long probandId, Boolean notify, Boolean na, Boolean email, Boolean phone, PSFVO psf) throws Exception {
		org.hibernate.Criteria probandContactDetailValueCriteria = createContactDetailValueCriteria();
		SubCriteriaMap criteriaMap = new SubCriteriaMap(ProbandContactDetailValue.class, probandContactDetailValueCriteria);
		if (probandId != null) {
			probandContactDetailValueCriteria.add(Restrictions.eq("proband.id", probandId.longValue()));
		}
		if (notify != null) {
			probandContactDetailValueCriteria.add(Restrictions.eq("notify", notify.booleanValue()));
		}
		if (na != null) {
			probandContactDetailValueCriteria.add(Restrictions.eq("na", na.booleanValue()));
		}
		if (email != null || phone != null) {
			org.hibernate.Criteria typeCriteria = probandContactDetailValueCriteria.createCriteria("type");
			if (email != null) {
				typeCriteria.add(Restrictions.eq("email", email.booleanValue()));
			}
			if (phone != null) {
				typeCriteria.add(Restrictions.eq("phone", phone.booleanValue()));
			}
		}
		// if (email != null) {
		// criteriaMap.createCriteria("type").add(Restrictions.eq("email", email.booleanValue()));
		// }
		// if (phone != null) {
		// criteriaMap.createCriteria("type").add(Restrictions.eq("phone", phone.booleanValue()));
		// }
		CriteriaUtil.applyPSFVO(criteriaMap, psf);
		return probandContactDetailValueCriteria.list();
	}

	@Override
	protected long handleGetCount(Long probandId, Boolean notify, Boolean na, Boolean email, Boolean phone) throws Exception {
		org.hibernate.Criteria probandContactDetailValueCriteria = createContactDetailValueCriteria();
		if (probandId != null) {
			probandContactDetailValueCriteria.add(Restrictions.eq("proband.id", probandId.longValue()));
		}
		if (notify != null) {
			probandContactDetailValueCriteria.add(Restrictions.eq("notify", notify.booleanValue()));
		}
		if (na != null) {
			probandContactDetailValueCriteria.add(Restrictions.eq("na", na.booleanValue()));
		}
		if (email != null || phone != null) {
			org.hibernate.Criteria typeCriteria = probandContactDetailValueCriteria.createCriteria("type");
			if (email != null) {
				typeCriteria.add(Restrictions.eq("email", email.booleanValue()));
			}
			if (phone != null) {
				typeCriteria.add(Restrictions.eq("phone", phone.booleanValue()));
			}
		}
		return (Long) probandContactDetailValueCriteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * Retrieves the entity object that is associated with the specified value object
	 * from the object store. If no such entity object exists in the object store,
	 * a new, blank entity is created
	 */
	private ProbandContactDetailValue loadProbandContactDetailValueFromProbandContactDetailValueInVO(ProbandContactDetailValueInVO probandContactDetailValueInVO) {
		ProbandContactDetailValue probandContactDetailValue = null;
		Long id = probandContactDetailValueInVO.getId();
		if (id != null) {
			probandContactDetailValue = this.load(id);
		}
		if (probandContactDetailValue == null) {
			probandContactDetailValue = ProbandContactDetailValue.Factory.newInstance();
		}
		return probandContactDetailValue;
	}

	/**
	 * Retrieves the entity object that is associated with the specified value object
	 * from the object store. If no such entity object exists in the object store,
	 * a new, blank entity is created
	 */
	private ProbandContactDetailValue loadProbandContactDetailValueFromProbandContactDetailValueOutVO(ProbandContactDetailValueOutVO probandContactDetailValueOutVO) {
		// TODO implement loadProbandContactDetailValueFromProbandContactDetailValueOutVO
		// throw new
		// UnsupportedOperationException("org.phoenixctms.ctsms.domain.loadProbandContactDetailValueFromProbandContactDetailValueOutVO(ProbandContactDetailValueOutVO) not yet implemented.");
		ProbandContactDetailValue probandContactDetailValue = this.load(probandContactDetailValueOutVO.getId());
		if (probandContactDetailValue == null) {
			probandContactDetailValue = ProbandContactDetailValue.Factory.newInstance();
		}
		return probandContactDetailValue;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public ProbandContactDetailValue probandContactDetailValueInVOToEntity(ProbandContactDetailValueInVO probandContactDetailValueInVO) {
		ProbandContactDetailValue entity = this.loadProbandContactDetailValueFromProbandContactDetailValueInVO(probandContactDetailValueInVO);
		this.probandContactDetailValueInVOToEntity(probandContactDetailValueInVO, entity, true);
		return entity;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void probandContactDetailValueInVOToEntity(
			ProbandContactDetailValueInVO source,
			ProbandContactDetailValue target,
			boolean copyIfNull) {
		super.probandContactDetailValueInVOToEntity(source, target, copyIfNull);
		// No conversion for target.value (can't convert source.getValue():java.lang.String to byte[]
		Long typeId = source.getTypeId();
		Long probandId = source.getProbandId();
		if (typeId != null) {
			target.setType(this.getContactDetailTypeDao().load(typeId));
		} else if (copyIfNull) {
			target.setType(null);
		}
		if (probandId != null) {
			Proband proband = this.getProbandDao().load(probandId);
			target.setProband(proband);
			proband.addContactDetailValues(target);
		} else if (copyIfNull) {
			Proband proband = target.getProband();
			target.setProband(null);
			if (proband != null) {
				proband.removeContactDetailValues(target);
			}
		}
		try {
			if (copyIfNull || source.getValue() != null) {
				CipherText cipherText = CryptoUtil.encryptValue(source.getValue());
				target.setValueIv(cipherText.getIv());
				target.setEncryptedValue(cipherText.getCipherText());
				target.setValueHash(CryptoUtil.hashForSearch(source.getValue()));
			}
			if (copyIfNull || source.getComment() != null) {
				CipherText cipherText = CryptoUtil.encryptValue(source.getComment());
				target.setCommentIv(cipherText.getIv());
				target.setEncryptedComment(cipherText.getCipherText());
				target.setCommentHash(CryptoUtil.hashForSearch(source.getComment()));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public ProbandContactDetailValue probandContactDetailValueOutVOToEntity(ProbandContactDetailValueOutVO probandContactDetailValueOutVO) {
		ProbandContactDetailValue entity = this.loadProbandContactDetailValueFromProbandContactDetailValueOutVO(probandContactDetailValueOutVO);
		this.probandContactDetailValueOutVOToEntity(probandContactDetailValueOutVO, entity, true);
		return entity;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void probandContactDetailValueOutVOToEntity(
			ProbandContactDetailValueOutVO source,
			ProbandContactDetailValue target,
			boolean copyIfNull) {
		super.probandContactDetailValueOutVOToEntity(source, target, copyIfNull);
		// No conversion for target.value (can't convert source.getValue():java.lang.String to byte[]
		ContactDetailTypeVO typeVO = source.getType();
		ProbandOutVO probandVO = source.getProband();
		UserOutVO modifiedUserVO = source.getModifiedUser();
		if (typeVO != null) {
			target.setType(this.getContactDetailTypeDao().contactDetailTypeVOToEntity(typeVO));
		} else if (copyIfNull) {
			target.setType(null);
		}
		if (probandVO != null) {
			Proband proband = this.getProbandDao().probandOutVOToEntity(probandVO);
			target.setProband(proband);
			proband.addContactDetailValues(target);
		} else if (copyIfNull) {
			Proband proband = target.getProband();
			target.setProband(null);
			if (proband != null) {
				proband.removeContactDetailValues(target);
			}
		}
		if (modifiedUserVO != null) {
			target.setModifiedUser(this.getUserDao().userOutVOToEntity(modifiedUserVO));
		} else if (copyIfNull) {
			target.setModifiedUser(null);
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public ProbandContactDetailValueInVO toProbandContactDetailValueInVO(final ProbandContactDetailValue entity) {
		return super.toProbandContactDetailValueInVO(entity);
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void toProbandContactDetailValueInVO(
			ProbandContactDetailValue source,
			ProbandContactDetailValueInVO target) {
		// TODO verify behavior of toProbandContactDetailValueInVO
		super.toProbandContactDetailValueInVO(source, target);
		// WARNING! No conversion for target.value (can't convert source.getValue():byte[] to java.lang.String
		ContactDetailType type = source.getType();
		Proband proband = source.getProband();
		if (type != null) {
			target.setTypeId(type.getId());
		}
		if (proband != null) {
			target.setProbandId(proband.getId());
		}
		try {
			target.setValue((String) CryptoUtil.decryptValue(source.getValueIv(), source.getEncryptedValue()));
			target.setComment((String) CryptoUtil.decryptValue(source.getCommentIv(), source.getEncryptedComment()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public ProbandContactDetailValueOutVO toProbandContactDetailValueOutVO(final ProbandContactDetailValue entity) {
		return super.toProbandContactDetailValueOutVO(entity);
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void toProbandContactDetailValueOutVO(
			ProbandContactDetailValue source,
			ProbandContactDetailValueOutVO target) {
		super.toProbandContactDetailValueOutVO(source, target);
		// WARNING! No conversion for target.value (can't convert source.getValue():byte[] to java.lang.String
		// WARNING! No conversion for target.modifiedUser (can't convert source.getModifiedUser():org.phoenixctms.ctsms.domain.User to org.phoenixctms.ctsms.vo.UserOutVO
		// WARNING! No conversion for target.proband (can't convert source.getProband():org.phoenixctms.ctsms.domain.Proband to org.phoenixctms.ctsms.vo.ProbandOutVO
		// WARNING! No conversion for target.type (can't convert source.getType():org.phoenixctms.ctsms.domain.ContactDetailType to org.phoenixctms.ctsms.vo.ContactDetailTypeVO
		ContactDetailType type = source.getType();
		Proband proband = source.getProband();
		User modifiedUser = source.getModifiedUser();
		if (type != null) {
			target.setType(this.getContactDetailTypeDao().toContactDetailTypeVO(type));
		}
		if (proband != null) {
			target.setProband(this.getProbandDao().toProbandOutVO(proband));
		}
		if (modifiedUser != null) {
			target.setModifiedUser(this.getUserDao().toUserOutVO(modifiedUser));
		}
		try {
			if (!CoreUtil.isPassDecryption()) {
				throw new Exception();
			}
			target.setValue((String) CryptoUtil.decryptValue(source.getValueIv(), source.getEncryptedValue()));
			target.setComment((String) CryptoUtil.decryptValue(source.getCommentIv(), source.getEncryptedComment()));
			target.setDecrypted(true);
		} catch (Exception e) {
			target.setValue(null);
			target.setComment(null);
			target.setDecrypted(false);
		}
	}
}