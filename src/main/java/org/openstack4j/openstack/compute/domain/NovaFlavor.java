package org.openstack4j.openstack.compute.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack4j.model.common.Link;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.builder.FlavorBuilder;
import org.openstack4j.openstack.common.GenericLink;
import org.openstack4j.openstack.common.ListResult;

import com.google.common.base.Objects;

/**
 * An OpenStack Flavor which is a template used for configuration against
 * running Instances
 * 
 * @author Jeremy Unruh
 */
@JsonRootName("flavor")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NovaFlavor implements Flavor {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Integer ram;
	private Integer vcpus;
	private Integer disk;
	@JsonProperty("OS-FLV-EXT-DATA:ephemeral")
	private int ephemeral;
	private int swap;
	@JsonProperty("rxtx_factor")
	private float rxtxFactor = 1.0f;
	@JsonProperty("OS-FLV-DISABLED:disabled")
	private Boolean disabled;
	@JsonProperty("rxtx_quota")
	private Integer rxtxQuota;
	@JsonProperty("rxtx_cap")
	private Integer rxtxCap;
	@JsonProperty("os-flavor-access:is_public")
	private boolean isPublic = Boolean.TRUE;
	private List<GenericLink> links;

	public static FlavorBuilder builder() {
		return new FlavorConcreteBuilder();
	}

	@Override
	public FlavorBuilder toBuilder() {
		return new FlavorConcreteBuilder(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getRam() {
		return (ram == null) ? 0 : ram;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getVcpus() {
		return (vcpus == null) ? 0 : vcpus;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDisk() {
		return (disk == null) ? 0 : disk;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSwap() {
		return swap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float getRxtxFactor() {
		return rxtxFactor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getEphemeral() {
		return ephemeral;
	}

	/**
	 * {@inheritDoc}
	 */
	@JsonIgnore
	@Override
	public int getRxtxQuota() {
		return (rxtxQuota == null) ? 0 : rxtxQuota;
	}

	/**
	 * {@inheritDoc}
	 */
	@JsonIgnore
	@Override
	public int getRxtxCap() {
		return (rxtxCap == null) ? 0 : rxtxCap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDisabled() {
		return (disabled == null) ? false : disabled;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<? extends Link> getLinks() {
		return links;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return Objects.toStringHelper(this).omitNullValues().add("id", id)
				.add("name", name).add("vcpus", vcpus).add("ram", ram)
				.add("disk", disk).add("ephemeral", ephemeral)
				.add("swap", swap).add("rxtx_factor", rxtxFactor)
				.add("disabled", disabled).add("rxtx_quota", rxtxQuota)
				.add("rxtx_cap", rxtxCap).add("is_public", isPublic)
				.add("links", links).addValue("\n").toString();
	}

	public static class Flavors extends ListResult<NovaFlavor> {

		private static final long serialVersionUID = 1L;

		@JsonProperty("flavors")
		List<NovaFlavor> flavors;

		public List<NovaFlavor> value() {
			return flavors;
		}
	}

	public static class FlavorConcreteBuilder implements FlavorBuilder {

		private NovaFlavor m;

		FlavorConcreteBuilder() {
			this(new NovaFlavor());
		}

		FlavorConcreteBuilder(NovaFlavor model) {
			this.m = model;
		}

		/**
		 * @see Flavor#getName()
		 */
		public FlavorBuilder name(String name) {
			m.name = name;
			return this;
		}

		/**
		 * @see Flavor#getRam()
		 */
		public FlavorBuilder ram(int ram) {
			m.ram = ram;
			return this;
		}

		/**
		 * @see Flavor#getVcpus()
		 */
		public FlavorBuilder vcpus(int vcpus) {
			m.vcpus = vcpus;
			return this;
		}

		/**
		 * @see Flavor#getDisk()
		 */
		public FlavorBuilder disk(int disk) {
			m.disk = disk;
			return this;
		}

		/**
		 * @see Flavor#getSwap()
		 */
		public FlavorBuilder swap(int swap) {
			m.swap = swap;
			return this;
		}

		/**
		 * @see Flavor#getRxtxFactor();
		 */
		public FlavorBuilder rxtxFactor(float rxtxFactor) {
			m.rxtxFactor = rxtxFactor;
			return this;
		}

		/**
		 * @see Flavor#isPublic()
		 */
		public FlavorBuilder isPublic(boolean isPublic) {
			m.isPublic = isPublic;
			return this;
		}

		@Override
		public Flavor build() {
			return m;
		}

		@Override
		public FlavorBuilder from(Flavor in) {
			m = (NovaFlavor) in;
			return this;
		}

	}

}
